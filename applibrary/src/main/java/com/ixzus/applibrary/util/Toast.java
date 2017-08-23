package com.ixzus.applibrary.util;

import com.ixzus.applibrary.base.BaseApplication;

import es.dmoral.toasty.Toasty;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/23.
 */

public class Toast {
    public static void show(String msg) {
        Toasty.normal(BaseApplication.getBaseApplication(), msg).show();
    }
}
