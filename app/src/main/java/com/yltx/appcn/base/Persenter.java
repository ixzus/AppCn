package com.yltx.appcn.base;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.main.home.HomeFragment;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class Persenter extends BasePresenter<Model, SplashActivity> implements Contract.IPresenter {
    @Override
    public void loadResult(String resultJson) {
        view.onResult(resultJson);
    }

    @Override
    public void loadData(Context contex, String tag) {
        view.getJson();
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
        model.doLoadData(contex, tag, json, this);
    }
}
