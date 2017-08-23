package com.yltx.appcn.cardetail;

import android.content.Context;

import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.login.LoginContract;
import com.yltx.appcn.net.RxRetrofit;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class CarDetailModel extends BaseModel implements CarDetailContract.ICarDetailModel {

    @Override
    public void GetCarDetail(Context context, String tag, String postJson, CarDetailContract.ICarDetailPresenter iLoginPresenter) {

    }
}
