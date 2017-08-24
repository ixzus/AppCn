package com.yltx.appcn.main.orderlist;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.CarServiceOrderRsObj;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class OrderListContract {
    interface IView extends BaseContract.IBaseView {

        String getUserId();

        String getOrderStatus();

        int getPageNo();

        int getPageSize();

        void onResult(CarServiceOrderRsObj result);

        void onResultErr();
    }

    interface IPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void loadResult(CarServiceOrderRsObj result);
        void loadErr();
    }

    interface IModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String userId, String status, int pageNo, int pageSize, IPresenter iPresenter);
    }
}
