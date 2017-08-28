package com.yltx.appcn.base;

import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ixzus.applibrary.base.BaseApplication;

import cn.jpush.android.api.JPushInterface;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/4.
 */

public class App extends BaseApplication {
    private static App mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        MultiDex.install(this);
        initRouter();
//        initLeakCanary();
        initJPush();
    }

    private void initJPush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    public static App getApplication() {
        return mApplication;
    }

    private void initRouter() {
//        if (BuildConfig.DEBUG) {
        if (true) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
    }

//    private void initLeakCanary() {
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
//    }
}
