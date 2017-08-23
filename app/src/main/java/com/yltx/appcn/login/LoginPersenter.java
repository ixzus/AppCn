package com.yltx.appcn.login;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.jingewenku.abrahamcaijin.commonutil.encryption.MD5Utils;
import com.yltx.appcn.bean.LoginBean;
import com.yltx.appcn.bean.LoginRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginPersenter extends BasePresenter<LoginModel, LoginActivity> implements LoginContract.ILoginPresenter {
    @Override
   public void loginResult(LoginRsBean mLoginRsBean)
    {
        view.onLoginResult(mLoginRsBean);
    }
    @Override
    public void login(Context contex, String tag) {
        LoginBean mLoginBean=new LoginBean();
        mLoginBean.setAccountName(view.getName());
        mLoginBean.setPassword(MD5Utils.encryptMD5(view.getPwd()));//MD5加密
        model.doLogin(contex, tag, mLoginBean, this);
    }
}
