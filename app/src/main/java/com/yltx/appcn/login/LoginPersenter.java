package com.yltx.appcn.login;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginPersenter extends BasePresenter<LoginModel, LoginActivity> implements LoginContract.ILoginPresenter {
    @Override
    public void getResult(String resultJson) {
        view.onLoginResult(resultJson);
    }

    @Override
    public void toLogin(Context contex, String tag) {
        view.getName();
        view.getPwd();
        String json = " {\"accountName\":\"13510378755\", \n" +
                "                                         \"cordova\":\"1.2.2\", \n" +
                "                                         \"ip\":\"\", \n" +
                "                                         \"loginChannel\":\"Android\", \n" +
                "                                         \"loginType\":\"mobilePhone\", \n" +
                "                                         \"model\":\"HUAWEI MT7-L09\", \n" +
                "                                         \"password\":\"e10adc3949ba59abbe56e057f20f883e\", \n" +
                "                                         \"platform\":\"Android\", \n" +
                "                                         \"reference\":\"cheguanjia\", \n" +
                "                                         \"uuid\":\"865276021651906\", \n" +
                "                                         \"version\":\"Huawei\"} ";
        model.doLogin(contex, tag, json, this);
    }
}
