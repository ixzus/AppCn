package com.yltx.appcn.main.home;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.HandleNum;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class HomeContract {
    interface IView extends BaseContract.IBaseView {
        String getUserId();

        void onResult(HandleNum result);
    }

    interface IPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void loadResult(HandleNum result);
    }

    interface IModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String param, IPresenter iLoginPresenter);
    }
}
