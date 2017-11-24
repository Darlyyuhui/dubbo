package com.darly.dview.framework;

import android.app.Activity;
import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.view.View;
/**
 * 映射查询类，直接针对findviewbyid进行拦截
 * @author  Darly/张宇辉/2017/11/23 14:42
 * @version  1.0/com.darly.dview.framework
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class ViewsFinder {
    private View view;
    private Activity activity;
    private PreferenceGroup preferenceGroup;
    private PreferenceActivity preferenceActivity;

    public ViewsFinder(View view) {
        this.view = view;
    }

    public ViewsFinder(Activity activity) {
        this.activity = activity;
    }

    public ViewsFinder(PreferenceGroup preferenceGroup) {
        this.preferenceGroup = preferenceGroup;
    }

    public ViewsFinder(PreferenceActivity preferenceActivity) {
        this.preferenceActivity = preferenceActivity;
        this.activity = preferenceActivity;
    }

    public View findViewById(int id) {
        return this.activity == null ? this.view.findViewById(id) : this.activity.findViewById(id);
    }

    public View findViewById(int id, int pid) {
        View pView = null;
        if (pid > 0) {
            pView = this.findViewById(pid);
        }

        View view = null;
        if (pView != null) {
            view = pView.findViewById(id);
        } else {
            view = this.findViewById(id);
        }
        return view;
    }

    public Preference findPreference(CharSequence key) {
        return this.preferenceGroup == null ? this.preferenceActivity.findPreference(key) : this.preferenceGroup.findPreference(key);
    }

    public Context getContext() {
        return (Context) (this.view != null ? this.view.getContext() : (this.activity != null ? this.activity : (this.preferenceActivity != null ? this.preferenceActivity : null)));
    }
}
