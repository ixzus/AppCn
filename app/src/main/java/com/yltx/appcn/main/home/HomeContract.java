package com.yltx.appcn.main.home;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class HomeContract {
    interface IView extends BaseContract.IBaseView {
        String getName();

        String getPwd();

        void onResult(String code);
    }

    interface IPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void loadResult(String resultJson);
    }

    interface IModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String postJson, IPresenter iLoginPresenter);
    }
}
