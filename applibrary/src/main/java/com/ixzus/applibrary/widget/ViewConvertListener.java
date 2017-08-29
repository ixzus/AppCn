package com.ixzus.applibrary.widget;

import android.support.v4.app.AbsDialog;

import java.io.Serializable;

public interface ViewConvertListener extends Serializable {
    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, AbsDialog dialog);
}