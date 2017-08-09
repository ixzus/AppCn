package com.ixzus.applibrary.base;

import android.app.Activity;
import android.os.Build;

import java.lang.ref.WeakReference;

/**
 * Created by xoutl on 2017/8/6.
 */

public class ActivityManager {
    public static final ActivityManager INSTANCE = new ActivityManager();
    private WeakReference<Activity> mCurrentActivity;

    public ActivityManager() {
    }

    public static ActivityManager getInstance() {
        return INSTANCE;
    }


    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (mCurrentActivity != null) {
            currentActivity = mCurrentActivity.get();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (currentActivity == null || currentActivity.isDestroyed()) {
                    currentActivity = null;
                }
            }
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = new WeakReference<Activity>(activity);
    }
}
