package com.yltx.appcn.main.orderlist.orderdetail;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.blankj.utilcode.util.KeyboardUtils;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.BaseDialog;
import com.ixzus.applibrary.widget.ViewConvertListener;
import com.ixzus.applibrary.widget.ViewHolder;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/order/OrderDetailActivity")
public class OrderDetailActivity extends RxAppCompatActivity {

    @BindView(R.id.oneBtn)
    SuperButton oneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.oneBtn)
    public void onViewClicked() {
        KeyboardUtils.showSoftInput(OrderDetailActivity.this);
        BaseDialog.init()
                .setLayoutId(R.layout.orderdetail_input)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final AbsDialog dialog) {
                        holder.setOnClickListener(R.id.inputCancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                KeyboardUtils.hideSoftInput(v);
                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.inputCommnit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                KeyboardUtils.hideSoftInput(v);
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .setDimAmount(0.3f)
                .setOutCancel(false)
                .setAnimStyle(R.style.DialogBottomAnimation)
                .show(getSupportFragmentManager());

    }

}
