package com.example.applibrary.base;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;

import com.example.applibrary.ActivityManager;

import es.dmoral.toasty.Toasty;

/**
 * Created by xoutl on 2017/8/6.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initLifecycle();
        initToast();
    }

    private void initToast() {
        Toasty.Config.getInstance()
                .setErrorColor(Color.RED) // optional
                .setInfoColor(Color.GRAY) // optional
                .setSuccessColor(Color.GREEN) // optional
                .setWarningColor(Color.YELLOW) // optional
                .setTextColor(Color.GRAY) // optional
                .setTextSize(12) // optional
                .apply(); // required
    }

    private void initLifecycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
                ActivityManager.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

}
