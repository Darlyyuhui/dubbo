package com.darly.chartlib.listener;

import com.darly.chartlib.data.DataSet;
import com.darly.chartlib.data.Entry;

/**
 * Listener for callbacks when drawing on the chart.
  * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
  * @author  Darly/张宇辉/2017/12/7 16:42
  * @version  1.0/com.darly.chartlib.listener
  */
 
public interface OnDrawListener {

	/**
	 * Called whenever an entry is added with the finger. Note this is also called for entries that are generated by the
	 * library, when the touch gesture is too fast and skips points.
	 * 
	 * @param entry
	 *            the last drawn entry
	 */
	void onEntryAdded(Entry entry);

	/**
	 * Called whenever an entry is moved by the user after beeing highlighted
	 * 
	 * @param entry
	 */
	void onEntryMoved(Entry entry);

	/**
	 * Called when drawing finger is lifted and the draw is finished.
	 * 
	 * @param dataSet
	 *            the last drawn DataSet
	 */
	void onDrawFinished(DataSet<?> dataSet);

}
