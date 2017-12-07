package com.darly.chartlib.highlight;

/**
 *  Class that represents the range of one value in a stacked bar entry. e.g.
 * stack values are -10, 5, 20 -> then ranges are (-10 - 0, 0 - 5, 5 - 25).
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:36
 * @version  1.0/com.darly.chartlib.highlight
 */

public final class Range {

	public float from;
	public float to;

	public Range(float from, float to) {
		this.from = from;
		this.to = to;
	}

	/**
	 * Returns true if this range contains (if the value is in between) the given value, false if not.
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(float value) {

		if (value > from && value <= to)
			return true;
		else
			return false;
	}

	public boolean isLarger(float value) {
		return value > to;
	}

	public boolean isSmaller(float value) {
		return value < from;
	}
}