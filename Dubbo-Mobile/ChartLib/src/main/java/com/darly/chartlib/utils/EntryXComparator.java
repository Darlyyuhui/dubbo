package com.darly.chartlib.utils;

import com.darly.chartlib.data.Entry;

import java.util.Comparator;

/**
 * Comparator for comparing Entry-objects by their x-value.
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:15
 * @version  1.0/com.darly.chartlib.utils
 */
public class EntryXComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry entry1, Entry entry2) {
        float diff = entry1.getX() - entry2.getX();

        if (diff == 0f) return 0;
        else {
            if (diff > 0f) return 1;
            else return -1;
        }
    }
}
