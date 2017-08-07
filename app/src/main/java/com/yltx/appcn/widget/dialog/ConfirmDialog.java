package com.yltx.appcn.widget.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.ViewHolder;
import com.yltx.appcn.R;

import java.io.Serializable;

public class ConfirmDialog extends AbsDialog {
    private String type;

    public static ConfirmDialog newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        type = bundle.getString("type");
        if (savedInstanceState != null) {
            confirmOkListener = (ConfirmOkListener) savedInstanceState.getSerializable("confirmOkListener");
            confirmCancelListener = (ConfirmCancelListener) savedInstanceState.getSerializable("confirmCancelListener");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("confirmOkListener", confirmOkListener);
        outState.putSerializable("confirmCancelListener", confirmCancelListener);
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_confirm;
    }

    @Override
    public void convertView(final ViewHolder viewHolder, final AbsDialog dialog) {
        if ("1".equals(type)) {
            viewHolder.setText(R.id.title, "提示");
            viewHolder.setText(R.id.message, "您已支付成功！");
        } else if ("2".equals(type)) {
            viewHolder.setText(R.id.title, "警告");
            viewHolder.setText(R.id.message, "您的账号已被冻结！");
        }
        viewHolder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmCancelListener.convertView(viewHolder, dialog);
            }
        });

        viewHolder.setOnClickListener(R.id.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOkListener.convertView(viewHolder, dialog);
            }
        });
    }

    private ConfirmOkListener confirmOkListener;

    public interface ConfirmOkListener extends Serializable {
        long serialVersionUID = System.currentTimeMillis();

        void convertView(ViewHolder holder, AbsDialog dialog);
    }

    private ConfirmCancelListener confirmCancelListener;

    public interface ConfirmCancelListener extends Serializable {
        long serialVersionUID = System.currentTimeMillis();

        void convertView(ViewHolder holder, AbsDialog dialog);
    }

    public ConfirmDialog setConfirmOkListener(ConfirmOkListener confirmOkListener) {
        this.confirmOkListener = confirmOkListener;
        return this;
    }

    public ConfirmDialog setConfirmCancelListener(ConfirmCancelListener confirmCancelListener) {
        this.confirmCancelListener = confirmCancelListener;
        return this;
    }
}