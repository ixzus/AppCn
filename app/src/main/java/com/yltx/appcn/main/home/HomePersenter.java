package com.yltx.appcn.main.home;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.HandleNum;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class HomePersenter extends BasePresenter<HomeModel, HomeFragment> implements HomeContract.IPresenter {
    @Override
    public void loadResult(HandleNum.DataBean result) {
        view.onResult(result);
    }

    @Override
    public void loadData(Context contex, String tag) {
        model.doLoadData(contex, tag, view.getUserId(), this);
    }
}
