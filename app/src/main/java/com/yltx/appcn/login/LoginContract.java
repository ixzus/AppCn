package com.yltx.appcn.login;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.LoginBean;
import com.yltx.appcn.bean.LoginRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginContract {
    interface ILoginView extends BaseContract.IBaseView {
        String getName();

        String getPwd();

        void onLoginResult(LoginRsBean mLoginRsBean);
    }

    interface ILoginPresenter extends BaseContract.IBasePresenter {
        void login(Context contex, String tag);

        void loginResult(LoginRsBean mLoginRsBean);
    }

    interface ILoginModel extends BaseContract.IBaseModel {
        void doLogin(Context context, String tag, LoginBean mLogin, ILoginPresenter iLoginPresenter);


    }
}
