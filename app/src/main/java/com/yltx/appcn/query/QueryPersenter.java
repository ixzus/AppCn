package com.yltx.appcn.query;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * Author：Wq
 * Date：2017/8/28 11:15
 * Description：//todo
 */

public class QueryPersenter extends BasePresenter<QueryModel,QueryActivity> implements QueryContract.IQueryPresenter{
    @Override
    public void loadData(Context contex, String tag) {

        model.doLoadData(contex,tag,view.getUserId(),view.getPageNo(),view.getPageSize(),view.getCarNum(),this);

    }

    @Override
    public void loadDataResult(CarServiceOrderRsObj.DataBean dataBean) {

        view.onLoadDataResult(dataBean);

    }

}
