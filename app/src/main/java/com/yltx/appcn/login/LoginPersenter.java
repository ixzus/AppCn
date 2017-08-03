package com.yltx.appcn.login;

import com.yltx.appcn.base.BasePresenter;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginPersenter extends BasePresenter<LoginModule, LoginActivity> implements LoginContract.ILoginPresenter {
    @Override
    public void getResult(String resultJson) {
        view.onLoginResult(resultJson);
    }

    public void toLogin() {
        module.toLogin(view.getPostJson(), this);
    }
}
