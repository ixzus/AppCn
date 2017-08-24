package com.yltx.appcn.main.home;

import android.content.Context;

import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.HandleNum;
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
        RxRetrofit.getInstance().getApiService().getToBeHandleNum(json)
                .compose(((RxAppCompatActivity)context).<HandleNum>bindToLifecycle())
                .compose(RxSchedulers.<HandleNum>io_main())
                .subscribe(new NetObserver<HandleNum>(context, TAG, 0, true) {

                    @Override
                    public void onSuccess(int whichRequest, HandleNum result) {
                        iLoginPresenter.loadResult(result);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        Toast.show(e.toString());
                    }
                });
    }
}
