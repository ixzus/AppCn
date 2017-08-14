package com.ixzus.applibrary.base;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;

import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.TimeUnit;

import es.dmoral.toasty.Toasty;
import okhttp3.OkHttpClient;

/**
 * Created by xoutl on 2017/8/6.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        init();
    }

    public static BaseApplication getBaseApplication() {
        return baseApplication;
    }

    private void init() {
        initLeakCanary();
        initUtilCode();
        initLifecycle();
        initToast();
        initLogger();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private void initUtilCode() {
        Utils.init(baseApplication);
    }

    public void setTimeOut(long timeOut) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(timeOut, TimeUnit.MILLISECONDS);

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
