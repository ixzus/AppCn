package com.yltx.appcn.main.orderlist;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.ResultInfo;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class OrderListPersenter extends BasePresenter<OrderListModel, OrderListFragment> implements OrderListContract.IPresenter {
    @Override
    public void loadResult(CarServiceOrderRsObj result) {
        view.onResult(result);
    }

    @Override
    public void takeOrderResult(ResultInfo resultInfo) {
        view.onTakeOrderResult(resultInfo);
    }

    @Override
    public void loadErr() {
        view.onResultErr();
    }

    @Override
    public void loadData(Context contex, String tag) {
        model.doLoadData(contex, tag, view.getUserId(), view.getOrderStatus(), view.getPageNo(), view.getPageSize(), this);
    }

    @Override
    public void takeOrder(Context contex, String tag) {
        model.doTakeOrder(contex, tag, view.getIds(), view.getOrderStatus(), view.getUserId(), view.getUserName(), this);
    }
}
