package com.yltx.appcn.main;

import android.content.Context;

import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.net.RxRetrofit;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class HomeModel extends BaseModel implements HomeContract.IModel {
    @Override
    public void doLoadData(Context context, final String TAG, final String json, final HomeContract.IPresenter iLoginPresenter) {
        LoginInfo loginInfo = new Gson().fromJson(json, LoginInfo.class);
        RxRetrofit.getInstance().getApiService().login(loginInfo)
                .compose(((RxAppCompatActivity)context).<Member>bindToLifecycle())
                .compose(RxSchedulers.<Member>io_main())
                .subscribe(new NetObserver<Member>(context, TAG, 0, true) {

                    @Override
                    public void onSuccess(int whichRequest, Member member) {
                        iLoginPresenter.loadResult(new Gson().toJson(member));
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        iLoginPresenter.loadResult(e.toString());
                    }
                });
    }
}
