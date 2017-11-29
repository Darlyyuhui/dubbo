package com.darly.dview.widget.xlistView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.darly.dview.R;
/**
 * ListView、GridView和ScrollView统一上拉下拉刷新
 * @author  Darly/张宇辉/2017/11/23 14:45
 * @version  1.0/com.darly.dview.widget.xlistView
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class XLinearLayout extends LinearLayout {
	// refresh state
	private static final int PULL_TO_REFRESH = 2;
	private static final int RELEASE_TO_REFRESH = 3;
	private static final int REFRESHING = 4;
	// pull state
	private static final int PULL_UP_STATE = 0;
	private static final int PULL_DOWN_STATE = 1;

	private View mHeaderView;
	private View mFooterView;

	private int mHeaderViewHeight;
	private int mFooterViewHeight;

	private ImageView mHeaderStartView;
	private ImageView mHeaderFinishView;
	private ProgressBar mHeaderProgressBar;
	private TextView mHeaderTipView;

	private TextView mFooterTipView;

	private int mHeaderState;
	private int mFooterState;

	private AdapterView<?> mAdapterView;
	private ScrollView mScrollView;
	private int mLastMotionY;

	// 是否允许上拉
	private boolean isDownReflash = true;
	// 是否允许上拉
	private boolean isUpReflash = true;
	// 上拉状态
	private int mPullState;
	// 动态布局
	private LayoutInflater mInflater;
	// 改变箭头方向为向下箭头
	private RotateAnimation mFlipAnimation;
	// 改变为逆向的箭头：旋转
	private RotateAnimation mReverseFlipAnimation;
	// 控制接口
	private IXLinearLayoutListener mXLinearLayoutListener;

	public XLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public XLinearLayout(Context context) {
		super(context);
		init();
	}

	private void init() {
		// 需要设置垂直
		setOrientation(LinearLayout.VERTICAL);
		// Load all of the animations we need in code rather than through XML
		mFlipAnimation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		mFlipAnimation.setInterpolator(new LinearInterpolator());
		mFlipAnimation.setDuration(250);
		mFlipAnimation.setFillAfter(true);
		mReverseFlipAnimation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		mReverseFlipAnimation.setInterpolator(new LinearInterpolator());
		mReverseFlipAnimation.setDuration(250);
		mReverseFlipAnimation.setFillAfter(true);

		mInflater = LayoutInflater.from(getContext());
		addHeaderView();
	}

	private void addHeaderView() {
		mHeaderView = mInflater.inflate(R.layout.xlinearlayout_header, this, false);

		mHeaderStartView = (ImageView) mHeaderView.findViewById(R.id.xlinearlayout_header_arrow);
		mHeaderTipView = (TextView) mHeaderView.findViewById(R.id.xlinearlayout_header_hint_textview);
		mHeaderProgressBar = (ProgressBar) mHeaderView.findViewById(R.id.xlinearlayout_header_progressbar);
		mHeaderFinishView = (ImageView) mHeaderView.findViewById(R.id.xlinearlayout_refresh_complete);
		// header layout
		measureView(mHeaderView);
		mHeaderViewHeight = mHeaderView.getMeasuredHeight();
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, mHeaderViewHeight);
		// 设置topMargin的值为负的HeaderView高度，即将其隐藏在最上方
		params.topMargin = -(mHeaderViewHeight);
		addView(mHeaderView, params);
	}

	private void addFooterView() {
		mFooterView = mInflater.inflate(R.layout.xlinearlayout_footer, this, false);

		mFooterTipView = (TextView) mFooterView.findViewById(R.id.xlinearlayout_footer_hint_textview);
		measureView(mFooterView);
		mFooterViewHeight = mFooterView.getMeasuredHeight();
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, mFooterViewHeight);
		addView(mFooterView, params);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		addFooterView();
		initContentAdapterView();
	}

	/**
	 * 初始化
	 */
	private void initContentAdapterView() {
		int count = getChildCount();
		if (count < 3) {
			throw new IllegalArgumentException("This layout must contain three child views,and AdapterView or ScrollView must in the second position.");
		}
		View view = null;
		for (int i = 0; i < count - 1; ++i) {
			view = getChildAt(i);
			if (view instanceof AdapterView<?>) {
				mAdapterView = (AdapterView<?>) view;
			}
			if (view instanceof ScrollView) {
				mScrollView = (ScrollView) view;
			}
		}
		if (mAdapterView == null && mScrollView == null) {
			throw new IllegalArgumentException("must contain a AdapterView or ScrollView in this layout!");
		}
	}

	@SuppressWarnings("deprecation")
	private void measureView(View child) {
		ViewGroup.LayoutParams param = child.getLayoutParams();
		if (param == null) {
			param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, param.width);
		int lpHeight = param.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent e) {
		int y = (int) e.getRawY();
		switch (e.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// 首先拦截down事件,记录y坐标
			mLastMotionY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			// deltaY > 0 是向下运动,deltaY < 0是向上运动
			int deltaY = y - mLastMotionY;
			if (isRefreshViewScroll(deltaY)) {
				return true;
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			break;
		}
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int y = (int) event.getRawY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:
			int deltaY = y - mLastMotionY;
			if (mPullState == PULL_DOWN_STATE && isDownReflash) {// 执行下拉
				headerPrepareToRefresh(deltaY);
			} else if (mPullState == PULL_UP_STATE && isUpReflash) {// 执行上拉
				footerPrepareToRefresh(deltaY);
			}
			mLastMotionY = y;
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			int topMargin = getHeaderTopMargin();
			if (mPullState == PULL_DOWN_STATE) {
				if (topMargin >= 0) {
					// 开始执行header刷新
					headerRefreshing();
				} else {
					// 还没有执行刷新：重新隐藏
					setHeaderTopMargin(-mHeaderViewHeight);
				}
			} else if (mPullState == PULL_UP_STATE) {
				if (Math.abs(topMargin) >= mHeaderViewHeight + mFooterViewHeight) {
					// 开始执行footer刷新
					footerRefreshing();
				} else {
					// 还没有执行刷新：重新隐藏
					setHeaderTopMargin(-mHeaderViewHeight);
				}
			}
			break;
		}
		return super.onTouchEvent(event);
	}

	/**
	 * 是否应该到了父View，即PullToRefreshView滑动
	 * @param deltaY 0 是向下运动
	 * @return boolean
	 */
	private boolean isRefreshViewScroll(int deltaY) {
		if (mHeaderState == REFRESHING || mFooterState == REFRESHING) {
			return false;
		}
		// 对于ListView和GridView
		if (mAdapterView != null) {
			// 子view(ListView or GridView)滑动到最顶端
			if (deltaY > 0) {
				View child = mAdapterView.getChildAt(0);
				if (child == null) {
					// 如果mAdapterView中没有数据不拦截
					return false;
				}
				if (mAdapterView.getFirstVisiblePosition() == 0 && child.getTop() == 0) {
					mPullState = PULL_DOWN_STATE;
					return true;
				}
				int top = child.getTop();
				int padding = mAdapterView.getPaddingTop();
				if (mAdapterView.getFirstVisiblePosition() == 0 && Math.abs(top - padding) <= 8) {// 这里之前用3可以判断,但现在不行,还没找到原因
					mPullState = PULL_DOWN_STATE;
					return true;
				}

			} else if (deltaY < 0) {
				View lastChild = mAdapterView.getChildAt(mAdapterView.getChildCount() - 1);
				if (lastChild == null) {
					// 如果mAdapterView中没有数据不拦截
					return false;
				}
				// 最后一个子view的Bottom小于父View的高度说明mAdapterView的数据没有填满父view，等于父View的高度说明mAdapterView已经滑动到最后
				if (lastChild.getBottom() <= getHeight() && mAdapterView.getLastVisiblePosition() == mAdapterView.getCount() - 1) {
					mPullState = PULL_UP_STATE;
					return true;
				}
			}
		}
		// 对于ScrollView
		if (mScrollView != null) {
			// 子scroll view滑动到最顶端
			View child = mScrollView.getChildAt(0);
			if (deltaY > 0 && mScrollView.getScrollY() == 0) {
				mPullState = PULL_DOWN_STATE;
				return true;
			} else if (deltaY < 0 && child.getMeasuredHeight() <= getHeight() + mScrollView.getScrollY()) {
				mPullState = PULL_UP_STATE;
				return true;
			}
		}
		return false;
	}

	/**
	 * header 准备刷新,手指移动过程,还没有释放
	 * @param deltaY	手指滑动的距离
	 */
	private void headerPrepareToRefresh(int deltaY) {
		int newTopMargin = changingHeaderViewTopMargin(deltaY);
		// 当header view的topMargin>=0时，说明已经完全显示出来了,修改header view 的提示状态
		if (newTopMargin >= 0 && mHeaderState != RELEASE_TO_REFRESH) {
			mHeaderTipView.setText(R.string.xlistview_header_hint_ready);
			mHeaderStartView.clearAnimation();
			mHeaderStartView.startAnimation(mFlipAnimation);
			mHeaderState = RELEASE_TO_REFRESH;
		} else if (newTopMargin < 0 && newTopMargin > -mHeaderViewHeight) {// 拖动时没有释放
			mHeaderStartView.clearAnimation();
			mHeaderStartView.startAnimation(mFlipAnimation);
			mHeaderTipView.setText(R.string.xlistview_header_hint_normal);
			mHeaderState = PULL_TO_REFRESH;
		}
	}

	/**
	 * footer 准备刷新,手指移动过程,还没有释放 移动footer view高度同样和移动header view
	 * 高度是一样，都是通过修改header view的topMargin的值来达到
	 * @param deltaY 手指滑动的距离
	 */
	private void footerPrepareToRefresh(int deltaY) {
		int newTopMargin = changingHeaderViewTopMargin(deltaY);
		// 如果header view topMargin 的绝对值大于或等于header + footer的高度
		// 说明footer view 完全显示出来了，修改footer view 的提示状态
		if (Math.abs(newTopMargin) >= (mHeaderViewHeight + mFooterViewHeight) && mFooterState != RELEASE_TO_REFRESH) {
			mFooterTipView.setText(R.string.xlistview_footer_hint_ready);
			mFooterState = RELEASE_TO_REFRESH;
		} else if (Math.abs(newTopMargin) < (mHeaderViewHeight + mFooterViewHeight)) {
			mFooterTipView.setText(R.string.xlistview_footer_hint_normal);
			mFooterState = PULL_TO_REFRESH;
		}
	}

	/**
	 * 修改Header view top margin的值
	 * @param deltaY    距离
	 * @return	int
	 */
	private int changingHeaderViewTopMargin(int deltaY) {
		LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
		float newTopMargin = params.topMargin + deltaY * 0.3f;
		// 这里对上拉做一下限制，因为当前上拉后然后不释放手指直接下拉,会把下拉刷新给触发了
		// 表示如果是在上拉后一段距离,然后直接下拉
		if (deltaY > 0 && mPullState == PULL_UP_STATE && Math.abs(params.topMargin) <= mHeaderViewHeight) {
			return params.topMargin;
		}
		// 同样地,对下拉做一下限制，避免出现跟上拉操作时一样Bug
		if (deltaY < 0 && mPullState == PULL_DOWN_STATE && Math.abs(params.topMargin) >= mHeaderViewHeight) {
			return params.topMargin;
		}
		params.topMargin = (int) newTopMargin;
		mHeaderView.setLayoutParams(params);
		invalidate();
		return params.topMargin;
	}

	/**
	 * header refreshing
	 */
	private void headerRefreshing() {
		mHeaderState = REFRESHING;
		setHeaderTopMargin(0);
		mHeaderStartView.setVisibility(View.GONE);
		mHeaderStartView.clearAnimation();
		mHeaderStartView.setImageDrawable(null);
		mHeaderProgressBar.setVisibility(View.VISIBLE);
		mHeaderTipView.setText(R.string.xlistview_header_hint_loading);
		if (mXLinearLayoutListener != null) {
			mXLinearLayoutListener.onHeaderRefresh(this);
		}
	}

	/**
	 * footer refreshing
	 */
	private void footerRefreshing() {
		mFooterState = REFRESHING;
		int top = mHeaderViewHeight + mFooterViewHeight;
		setHeaderTopMargin(-top);
		mFooterTipView.setText(R.string.xlistview_header_hint_loading);
		if (mXLinearLayoutListener != null) {
			mXLinearLayoutListener.onFooterRefresh(this);
		}
	}

	/**
	 * 设置header view的topMargin的值
	 * @param topMargin	为0时说明header view 刚好完全显示出来； 为-mHeaderViewHeight时说明完全隐藏。
	 */
	private void setHeaderTopMargin(int topMargin) {
		LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
		params.topMargin = topMargin;
		mHeaderView.setLayoutParams(params);
		invalidate();
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressLint("HandlerLeak")
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				mHeaderFinishView.setVisibility(View.GONE);
				setHeaderTopMargin(-mHeaderViewHeight);
				mHeaderStartView.setVisibility(View.VISIBLE);
				mHeaderStartView.setImageResource(R.mipmap.xlistview_arrow_dowm);
				mHeaderTipView.setText(R.string.xlistview_header_hint_normal);
				mHeaderState = PULL_TO_REFRESH;
				break;
			case 2:
				setHeaderTopMargin(-mHeaderViewHeight);
				mFooterTipView.setText(R.string.xlistview_footer_hint_ready);
				mFooterState = PULL_TO_REFRESH;
				break;
			}
		};
	};

	/**
	 * header view 完成更新后恢复初始状态
	 */
	public void onHeaderRefreshComplete() {
		mHeaderStartView.setVisibility(View.GONE);
		mHeaderProgressBar.setVisibility(View.GONE);
		mHeaderFinishView.setVisibility(View.VISIBLE);
		mHeaderTipView.setText("加载完成");
		handler.sendEmptyMessageDelayed(1, 200);
	}

	/**
	 * footer view 完成更新后恢复初始状态
	 */
	public void onFooterRefreshComplete() {
		handler.sendEmptyMessageDelayed(2, 200);
	}

	private int getHeaderTopMargin() {
		LayoutParams params = (LayoutParams) mHeaderView.getLayoutParams();
		return params.topMargin;
	}

	public void setIXLinearLayoutListener(IXLinearLayoutListener iXLinearLayoutListener) {
		mXLinearLayoutListener = iXLinearLayoutListener;
	}

	// 暴露是否上拉
	public void setFootViewShow(boolean isShow) {
		isUpReflash = isShow;
	}

	// 暴露是否下拉
	public void setHeadViewShow(boolean isShow) {
		isDownReflash = isShow;
	}

	public interface IXLinearLayoutListener {
		public void onHeaderRefresh(XLinearLayout view);

		public void onFooterRefresh(XLinearLayout view);
	}
}
