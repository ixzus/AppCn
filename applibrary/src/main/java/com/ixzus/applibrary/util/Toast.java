package com.ixzus.applibrary.util;

import com.ixzus.applibrary.base.BaseApplication;

import es.dmoral.toasty.Toasty;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/23.
 */

public class Toast {
    public static void show(String msg) {
        Toasty.info(BaseApplication.getBaseApplication(), msg).show();
    }

    public static void showSuccess(String msg) {
        Toasty.success(BaseApplication.getBaseApplication(), msg).show();
    }

    public static void showError(String msg) {
        Toasty.error(BaseApplication.getBaseApplication(), msg).show();
    }
}
