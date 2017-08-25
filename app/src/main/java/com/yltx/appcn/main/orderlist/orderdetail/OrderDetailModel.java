package com.yltx.appcn.main.orderlist.orderdetail;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.OrderDetail;
import com.yltx.appcn.bean.ResultInfo;
import com.yltx.appcn.bean.TakeOrder;
import com.yltx.appcn.net.RxRetrofit;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/25.
 */

public class OrderDetailModel extends BaseModel implements OrderDetailContract.IModel {
    @Override
    public void loadOrder(Context context, String TAG, String orderId, final OrderDetailContract.IPresenter iPresenter) {
        RxRetrofit.getInstance().getApiService().getOrderDetail(orderId)
                .compose(((RxAppCompatActivity) context).<OrderDetail>bindToLifecycle())
                .compose(RxSchedulers.<OrderDetail>io_main())
                .subscribe(new NetObserver<OrderDetail>(context, TAG, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, OrderDetail result) {
                        iPresenter.onLoadOrderResult(result);

                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {

                    }
                });

    }

    @Override
    public void dealOrder(Context context, String TAG, String id, String status, String personNo, String personName,String remark, final OrderDetailContract.IPresenter iPresenter) {
        TakeOrder takeOrder = new TakeOrder();
        takeOrder.setId(id);
        takeOrder.setStatus(status);
        takeOrder.setHandlePersonNo(personNo);
        takeOrder.setHandlePersonName(personName);
        takeOrder.setRemark(remark);
        RxRetrofit.getInstance().getApiService().processOrder(takeOrder)
                .compose(((RxAppCompatActivity) context).<ResultInfo>bindToLifecycle())
                .compose(RxSchedulers.<ResultInfo>io_main())
                .subscribe(new NetObserver<ResultInfo>(context, TAG, 1, true) {

                    @Override
                    public void onSuccess(int whichRequest, ResultInfo result) {
                        if (null != result) {
                            if ("success".equals(result.getCode())) {
                                iPresenter.onDealOrderResult(result);
                            }
                            Toast.show(result.getMessage());
                        }
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        Toast.show(e.toString());
                    }
                });
    }

    @Override
    public void uploadPic(Context context, String TAG, OrderDetailContract.IPresenter iPresenter) {

    }
}
