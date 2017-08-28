package com.yltx.appcn.base;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.UpGrade;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class SplashContract {
    interface IView extends BaseContract.IBaseView {

        String getVersionCode();

        void onResult(UpGrade result);
    }

    interface IPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void loadResult(String resultJson);
    }

    interface IModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag, String versionCode, IPresenter iLoginPresenter);
    }
}
