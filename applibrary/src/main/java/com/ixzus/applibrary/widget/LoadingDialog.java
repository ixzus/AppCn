package com.ixzus.applibrary.widget;

import android.support.v4.app.AbsDialog;
import android.support.v4.app.FragmentManager;

import com.ixzus.applibrary.R;

public class LoadingDialog extends AbsDialog {


    public static LoadingDialog init() {
        return new LoadingDialog();
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void convertView(ViewHolder holder, AbsDialog dialog) {
    }

    @Override
    public AbsDialog show(FragmentManager manager) {
        return super.show(manager);
    }

}