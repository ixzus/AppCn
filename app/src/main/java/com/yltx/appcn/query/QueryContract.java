package com.yltx.appcn.query;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class QueryContract {
    interface IQueryView extends BaseContract.IBaseView {
        void onLoadDataResult(CarServiceOrderRsObj.DataBean dataBean);

        String getInput();

        String getUserId();

        int getPageNo();

        int getPageSize();

        String getCarNum();




    }
    interface IQueryPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);
        void  loadDataResult(CarServiceOrderRsObj.DataBean dataBean);
    }
    interface IQueryModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String memenber,int pagerNum,int pagerSize,String carNum, IQueryPresenter mPresenter);//发送验证码
    }
}
