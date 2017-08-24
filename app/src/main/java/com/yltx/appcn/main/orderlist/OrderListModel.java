package com.yltx.appcn.main.orderlist;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.ResultInfo;
import com.yltx.appcn.bean.TakeOrder;
import com.yltx.appcn.net.RxRetrofit;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class OrderListModel extends BaseModel implements OrderListContract.IModel {

    @Override
    public void doLoadData(Context context, String TAG, String userId, String status, int pageNo, int pageSize, final OrderListContract.IPresenter iPresenter) {
        RxRetrofit.getInstance().getApiService().getDispatchList(userId, status, pageNo, pageSize)
                .compose(((RxAppCompatActivity) context).<CarServiceOrderRsObj>bindToLifecycle())
                .compose(RxSchedulers.<CarServiceOrderRsObj>io_main())
                .subscribe(new NetObserver<CarServiceOrderRsObj>(context, TAG, 0, false) {

                    @Override
                    public void onSuccess(int whichRequest, CarServiceOrderRsObj result) {
                        iPresenter.loadResult(result);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        iPresenter.loadErr();
                    }
                });
    }

    @Override
    public void doTakeOrder(Context context, String TAG, String ids, String status, String personNo, String personName, final OrderListContract.IPresenter iPresenter) {
        TakeOrder takeOrder = new TakeOrder();
        takeOrder.setId(ids);
        takeOrder.setStatus("0703");
        takeOrder.setHandlePersonNo(personNo);
        takeOrder.setHandlePersonName(personName);
        RxRetrofit.getInstance().getApiService().processOrder(takeOrder)
                .compose(((RxAppCompatActivity) context).<ResultInfo>bindToLifecycle())
                .compose(RxSchedulers.<ResultInfo>io_main())
                .subscribe(new NetObserver<ResultInfo>(context, TAG, 1, true) {

                    @Override
                    public void onSuccess(int whichRequest, ResultInfo result) {
                        if (null != result) {
                            if ("success".equals(result.getCode())) {
                                iPresenter.takeOrderResult(result);
                            }
                            Toast.show(result.getMessage());
                        }
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        iPresenter.loadErr();
                    }
                });
    }
}
