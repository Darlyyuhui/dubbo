package com.darly.dview.widget.xlistView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.darly.dview.R;

/**
 * An ListView support (a) Pull down to refresh, (b) Pull up to load more.
 * 		Implement IXListViewListener, and see stopRefresh() / stopLoadMore().
 * @author  Darly/张宇辉/2017/11/23 14:45
 * @version  1.0/com.darly.dview.widget.xlistView
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class XListView extends ListView implements OnScrollListener {

	private float mLastY = -1; // save event y
	private Scroller mScroller; // used for scroll back
	private OnScrollListener mScrollListener; // user's scroll listener

	// the interface to trigger refresh and load more.
	private IXListViewListener mListViewListener;

	// -- header view
	public XListViewHeader mHeaderView;
	// header view content, use it to calculate the Header's height. And hide it
	// when disable pull refresh.
	private RelativeLayout mHeaderViewContent;
	// private TextView mHeaderTimeView;
	private int mHeaderViewHeight; // header view's height
	private boolean mEnablePullRefresh = true;
	private boolean mPullRefreshing = false; // is refreshing.

	// -- footer view
	public XListViewFooter mFooterView;
	private boolean mEnablePullLoad;
	private boolean mPullLoading;
	private boolean mIsFooterReady = false;

	// total list items, used to detect is at the bottom of listview.
	private int mTotalItemCount;

	// for mScroller, scroll back from header or footer.
	private int mScrollBack;
	private final static int SCROLLBACK_HEADER = 0;
	private final static int SCROLLBACK_FOOTER = 1;

	private final static int SCROLL_DURATION = 400; // scroll back duration
	private final static int PULL_LOAD_MORE_DELTA = 50; // when pull up >= 50px
														// at bottom, trigger
														// load more.
	private final static float OFFSET_RADIO = 1.8f; // support iOS like pull
													// feature.

	public XListView(Context context) {
		super(context);
		initWithContext(context);
	}

	public XListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initWithContext(context);
	}

	public XListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initWithContext(context);
	}

	private void initWithContext(Context context) {
		mScroller = new Scroller(context, new DecelerateInterpolator());
		// XListView need the scroll event, and it will dispatch the event to
		// user's listener (as a proxy).
		super.setOnScrollListener(this);

		// init header view
		mHeaderView = new XListViewHeader(context);
		mHeaderViewContent = (RelativeLayout) mHeaderView.findViewById(R.id.xlistview_header_content);
		// mHeaderTimeView = (TextView) mHeaderView
		// .findViewById(R.id.xlistview_header_time);
		addHeaderView(mHeaderView, null, false);

		// init footer view
		mFooterView = new XListViewFooter(context);

		// init header height
		mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onGlobalLayout() {
				mHeaderViewHeight = mHeaderViewContent.getHeight();
				getViewTreeObserver().removeGlobalOnLayoutListener(this);
			}
		});
	}

	@Override
	public void setAdapter(ListAdapter adapter) {
		// make sure XListViewFooter is the last footer view, and only add once.
		if (adapter.getCount() > 9) {
			if (mIsFooterReady == false) {
				mIsFooterReady = true;
				addFooterView(mFooterView);
			}
		}
		super.setAdapter(adapter);
	}

	@Override
	public void addFooterView(View v) {
		if (getFooterViewsCount() == 1) {
			return;
		}
		super.addFooterView(v);
	}

	@Override
	public void addFooterView(View v, Object data, boolean isSelectable) {
		if (getFooterViewsCount() == 1) {
			return;
		}
		super.addFooterView(v, data, isSelectable);
	}

	/**
	 * enable or disable pull down refresh feature.
	 * 
	 * @param enable    判断
	 */
	public void setPullRefreshEnable(boolean enable) {
		mEnablePullRefresh = enable;
		if (!mEnablePullRefresh) { // disable, hide the content
			mHeaderViewContent.setVisibility(View.INVISIBLE);
		} else {
			mHeaderViewContent.setVisibility(View.VISIBLE);
		}
	}

	/**
	 * enable or disable pull up load more feature.
	 * 
	 * @param enable 判断
	 */
	public void setPullLoadEnable(boolean enable) {
		mEnablePullLoad = enable;
		if (!mEnablePullLoad) {
			mFooterView.hide();
			mFooterView.setOnClickListener(null);
		} else {
			mPullLoading = false;
			mFooterView.show();
			mFooterView.setState(XListViewFooter.STATE_NORMAL);
			// both "pull up" and "click" will invoke load more.
			mFooterView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					startLoadMore();
				}
			});
		}
	}

	/**
	 * stop refresh, reset header view.
	 */
	public void stopRefresh() {
		if (mPullRefreshing == true) {
			mPullRefreshing = false;
			mHeaderView.onRefreshComplete();
		}

		Message msg = Message.obtain();
		msg.what = 1;
		handler.sendMessageDelayed(msg, 1000);
	}

	public void stopRefreshBecauseNetwork() {

		if (mPullRefreshing == true) {
			mPullRefreshing = false;
			mHeaderView.onNetworkFail();
		}

		Message msg = Message.obtain();
		msg.what = 1;
		handler.sendMessageDelayed(msg, 1000);

	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressLint("HandlerLeak")
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				resetHeaderHeight();
				break;
			case 2:
				mFooterView.setState(XListViewFooter.STATE_NORMAL);
				resetFooterHeight();
				break;
			}

		};
	};
	@SuppressLint("HandlerLeak")
	private Handler handler1 = new Handler() {
		public void handleMessage(Message msg) {
			mPullRefreshing = true;
			mHeaderView.setState(XListViewHeader.STATE_REFRESHING);
			if (mListViewListener != null) {
				mListViewListener.onRefresh(XListView.this);
			}
			resetHeaderHeight();
		};
	};

	@SuppressLint("HandlerLeak")
	private Handler handler2 = new Handler() {
		public void handleMessage(Message msg) {
			stopRefreshBecauseNetwork();
		};
	};

	/**
	 * stop load more, reset footer view.
	 */
	public void stopLoadMore() {
		if (mPullLoading == true) {
			mPullLoading = false;
			mFooterView.setState(XListViewFooter.STATE_NORMAL);
		}
	}

	// public void setRefreshTime(String time) {
	// mHeaderTimeView.setText(time);
	// }

	private void invokeOnScrolling() {
		if (mScrollListener instanceof OnXScrollListener) {
			OnXScrollListener l = (OnXScrollListener) mScrollListener;
			l.onXScrolling(this);
		}
	}

	public void updateHeaderHeight(float delta) {
		mHeaderView.setVisiableHeight((int) delta + mHeaderView.getVisiableHeight());
		if (mEnablePullRefresh && !mPullRefreshing) { // 未处于刷新状态，更新箭头
			if (mHeaderView.getVisiableHeight() > mHeaderViewHeight) {
				mHeaderView.setState(XListViewHeader.STATE_READY);
			} else {
				mHeaderView.setState(XListViewHeader.STATE_NORMAL);
			}
		}
		setSelection(0); // scroll to top each time
	}

	private void updateFooterHeight(float delta) {
		int height = mFooterView.getBottomMargin() + (int) delta;
		if (mEnablePullLoad && !mPullLoading) {
			if (height > PULL_LOAD_MORE_DELTA) { // height enough to invoke load
				mFooterView.setState(XListViewFooter.STATE_READY);
			} else {
				// mFooterView.setState(XListViewFooter.STATE_NORMAL);
			}
		}
		mFooterView.setBottomMargin(height);

		// setSelection(mTotalItemCount - 1); // scroll to bottom
	}

	/**
	 * reset header view's height.
	 */
	public void resetHeaderHeight() {
		int height = mHeaderView.getVisiableHeight();
		if (height == 0) // not visible.
			return;
		// refreshing and header isn't shown fully. do nothing.
		if (mPullRefreshing && height <= mHeaderViewHeight) {
			return;
		}
		int finalHeight = 0; // default: scroll back to dismiss header.
		// is refreshing, just scroll back to show all the header.
		if (mPullRefreshing && height > mHeaderViewHeight) {
			finalHeight = mHeaderViewHeight;
		}
		mScrollBack = SCROLLBACK_HEADER;
		mScroller.startScroll(0, height, 0, finalHeight - height, SCROLL_DURATION);
		// trigger computeScroll
		invalidate();
	}

	private void resetFooterHeight() {
		int bottomMargin = mFooterView.getBottomMargin();
		// mFooterView.setState(XListViewFooter.STATE_NORMAL);
		if (bottomMargin > 0) {
			mScrollBack = SCROLLBACK_FOOTER;
			mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, SCROLL_DURATION);
			invalidate();
		}
	}

	private void startLoadMore() {
//		if (!NetUtils.isNetworkAvailable(getContext())) {
//			mFooterView.setState(XListViewFooter.STATE_NORMAL);
//			mFooterView.onNetworkFail();
//			resetFooterHeight();
//			Message msg = Message.obtain();
//			msg.what = 2;
//			handler.sendMessageDelayed(msg, 1000);
//			return;
//		}

		mPullLoading = true;
		mFooterView.setState(XListViewFooter.STATE_LOADING);
		if (mListViewListener != null) {
			mListViewListener.onLoadMore(this);
		}
		resetFooterHeight();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (mLastY == -1) {
			mLastY = ev.getRawY();
		}

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mLastY = ev.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:

			// if(ev.getY() > mHeaderView.getVisiableHeight()){

			final float deltaY = ev.getRawY() - mLastY;
			mLastY = ev.getRawY();

			// Log.e("linglu","BottomMargin = " +
			// mFooterView.getBottomMargin());
			if (getFirstVisiblePosition() == 0 && (mHeaderView.getVisiableHeight() > 0 || deltaY > 0)) {
				// the first item is showing, header has shown or pull down.
				updateHeaderHeight(deltaY / OFFSET_RADIO);
				invokeOnScrolling();
			} else if (getLastVisiblePosition() == mTotalItemCount - 1 && (mFooterView.getBottomMargin() > 0 || deltaY < 0)) {
				// last item, already pulled up or want to pull up.

				// Log.e("linglu","BottomMargin = " +
				// mFooterView.getBottomMargin());
				// Log.e("linglu","deltaY = " + deltaY);

				updateFooterHeight(-deltaY / OFFSET_RADIO);
			}
			// }

			break;
		default:

			// if(ev.getY() > mHeaderView.getVisiableHeight()) {

			mLastY = -1; // reset
			if (getFirstVisiblePosition() == 0) {
				// invoke refresh
				if (mEnablePullRefresh && mHeaderView.getVisiableHeight() > mHeaderViewHeight) {

					mScroller.startScroll(0, mHeaderView.getVisiableHeight(), 0, mHeaderViewHeight - mHeaderView.getVisiableHeight(), 200);
					handler1.sendEmptyMessageDelayed(0, 201); // 必须比上一行的数大 1

				} else {
					resetHeaderHeight();
				}
			} else if (getLastVisiblePosition() == mTotalItemCount - 1) {
				// invoke load more.

				if (mEnablePullLoad && mFooterView.getBottomMargin() > PULL_LOAD_MORE_DELTA) {
					startLoadMore();
				} else {
					resetFooterHeight();
				}
			} else if (mFooterView.getBottomMargin() > PULL_LOAD_MORE_DELTA) {
				resetFooterHeight();
			}
			// }

			break;
		}

		return super.onTouchEvent(ev);
	}

	public void initRef() {
		mPullRefreshing = true;
		handler1.sendEmptyMessageDelayed(0, 0); // 必须比上一行的数大 1
		mHeaderView.setVisiableHeight(dip2px(getContext(), 50));
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 * @param context    引用类
	 * @param dpValue	dp值
	 * @return	int
	 */
	private int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
	/**
	 * 将sp值转换为px值，保证文字大小不变
	 *
	 * @param context    引用类
	 * @param spValue	sp值
	 * @return	int
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	@Override
	public void computeScroll() {
		if (mScroller.computeScrollOffset()) {
			if (mScrollBack == SCROLLBACK_HEADER) {
				mHeaderView.setVisiableHeight(mScroller.getCurrY());
			} else {
				mFooterView.setBottomMargin(mScroller.getCurrY());
			}
			postInvalidate();
			invokeOnScrolling();
		}
		super.computeScroll();
	}

	@Override
	public void setOnScrollListener(OnScrollListener l) {
		mScrollListener = l;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if (mScrollListener != null) {
			mScrollListener.onScrollStateChanged(view, scrollState);
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// send to user's listener
		mTotalItemCount = totalItemCount;
		if (mScrollListener != null) {
			mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
		}
	}

	public void setXListViewListener(IXListViewListener l) {
		mListViewListener = l;
	}

	/**
	 * you can listen ListView.OnScrollListener or this one. it will invoke
	 * onXScrolling when header/footer scroll back.
	 */
	public interface OnXScrollListener extends OnScrollListener {
		public void onXScrolling(View view);
	}

	/**
	 * implements this interface to get refresh/load more item.
	 */
	public interface IXListViewListener {
		public void onRefresh(View v);

		public void onLoadMore(View v);
	}
}
