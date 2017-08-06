package com.yltx.appcn.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.applibrary.base.BaseApplication;

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
        initRouter();
    }

    public static App getApplication() {
        return mApplication;
    }

    private void initRouter() {
        if (true) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
    }
}
