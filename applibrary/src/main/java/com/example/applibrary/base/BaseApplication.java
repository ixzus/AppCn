package com.example.applibrary.base;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.applibrary.ActivityManager;
import com.example.applibrary.R;
import com.example.applibrary.impl.IActivity;
import com.example.applibrary.impl.ISwipeBack;
import com.example.applibrary.impl.IToolbar;
import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * Created by xoutl on 2017/8/6.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLifecycle();
    }

    private void initLifecycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof IActivity) {
                    activity.setContentView(((IActivity) activity).initLayout());
                    ((IActivity) activity).initView();
                    ((IActivity) activity).initData();
                }

                if (activity instanceof IToolbar) {
                    initToolbar(activity);
                }

                if (activity instanceof ISwipeBack) {
                    SwipeBackHelper.onCreate(activity);
                }

            }

            @Override
            public void onActivityStarted(Activity activity) {
                if (activity instanceof ISwipeBack) {
                    SwipeBackHelper.onPostCreate(activity);
                }
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
                if (activity instanceof ISwipeBack) {
                    SwipeBackHelper.onDestroy(activity);
                }
            }
        });
    }

    private void initToolbar(final Activity activity) {
        if (activity.findViewById(R.id.toolbar) != null) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).setSupportActionBar((Toolbar) activity.findViewById(R.id.toolbar));
                ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.setActionBar((android.widget.Toolbar) activity.findViewById(R.id.toolbar));
                    activity.getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }

//        if (activity.findViewById(R.id.toolbar_title) != null) {
//            ((TextView) activity.findViewById(R.id.toolbar_title)).setText(activity.getTitle());
//        }
        if (activity.findViewById(R.id.toolbar_back) != null) {
            activity.findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onBackPressed();
                }
            });
        }

    }
}
