package com.yltx.appcn.main.orderlist;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.ResultInfo;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class OrderListContract {
    interface IView extends BaseContract.IBaseView {

        String getUserId();

        String getUserName();

        String getOrderStatus();

        int getPageNo();

        int getPageSize();

        void onResult(CarServiceOrderRsObj result);

        void onResultErr();

        void onTakeOrderResult(ResultInfo resultInfo);

        String getIds();


    }

    interface IPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void takeOrder(Context contex, String tag);

        void loadResult(CarServiceOrderRsObj result);

        void takeOrderResult(ResultInfo resultInfo);

        void loadErr();
    }

    interface IModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String userId, String status, int pageNo, int pageSize, IPresenter iPresenter);

        void doTakeOrder(Context context, String tag, String ids, String status, String personNo, String personName, IPresenter iPresenter);
    }
}
