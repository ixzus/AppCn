package com.yltx.appcn.main.orderlist.orderdetail;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.R;

@Route(path = "/order/OrderDetailActivity")
public class OrderDetailActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
    }
}
