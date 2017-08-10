package com.yltx.appcn.login;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginContract {
    interface ILoginView extends BaseContract.IBaseView {
        String getName();

        String getPwd();

        void onLoginResult(String code);
    }

    interface ILoginPresenter extends BaseContract.IBasePresenter {
        void getResult(String resultJson);
    }

    interface ILoginModel extends BaseContract.IBaseModel {
        void toLogin(Context context, String tag, String postJson, ILoginPresenter iLoginPresenter);
    }
}
