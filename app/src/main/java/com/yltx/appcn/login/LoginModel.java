package com.yltx.appcn.login;

import android.content.Context;

import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.LoginBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.LoginRsBean;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.net.RxRetrofit;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class LoginModel extends BaseModel implements LoginContract.ILoginModel {
    @Override
    public void doLogin(Context context, final String TAG, final LoginBean mLoginBean, final LoginContract.ILoginPresenter iLoginPresenter) {

        RxRetrofit.getInstance().getApiService().login(mLoginBean)
                .compose(((RxAppCompatActivity)context).<LoginRsBean>bindToLifecycle())
                .compose(RxSchedulers.<LoginRsBean>io_main())
                .subscribe(new NetObserver<LoginRsBean>(context, TAG, 0, true) {


                    @Override
                    public void onSuccess(int whichRequest, LoginRsBean loginRsBean) {
//                        iLoginPresenter.loginResult(new Gson().toJson(member));
                        iLoginPresenter.loginResult(loginRsBean);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });
    }
}
