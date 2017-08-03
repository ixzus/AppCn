package com.yltx.appcn.login;

import android.os.Bundle;

import com.yltx.appcn.R;
import com.yltx.appcn.base.BaseActivity;
import com.yltx.appcn.base.BaseModule;

public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter> implements LoginContract.ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseModule initModule() {
        return new LoginModule();
    }

    @Override
    protected LoginPersenter initPresenter() {
        return new LoginPersenter();
    }

    @Override
    public String getPostJson() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void onLoginResult(String code) {

    }
}
