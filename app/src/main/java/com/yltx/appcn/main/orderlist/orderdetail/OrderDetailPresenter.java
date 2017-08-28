package com.yltx.appcn.main.orderlist.orderdetail;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.OrderDetail;
import com.yltx.appcn.bean.ResultInfo;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/25.
 */

public class OrderDetailPresenter extends BasePresenter<OrderDetailModel, OrderDetailActivity> implements OrderDetailContract.IPresenter {
    @Override
    public void loadOrder(Context context, String TAG) {
        model.loadOrder(context, TAG, view.getOrderId(), this);
    }

    @Override
    public void dealOrder(Context context, String TAG) {
        model.dealOrder(context, TAG, view.getOrderId(), view.getOrderStatus(), view.getUserId(), view.getUserName(), view.getRemark(),view.getFileList(), this);
    }

    @Override
    public void uploadPic(Context context, String TAG) {

    }

    @Override
    public void onLoadOrderResult(OrderDetail result) {
        view.onLoadOrderResult(result);
    }

    @Override
    public void onDealOrderResult(ResultInfo result) {
        view.onDealOrderResult(result);
    }


    @Override
    public void onUploadPicResult() {

    }
}
