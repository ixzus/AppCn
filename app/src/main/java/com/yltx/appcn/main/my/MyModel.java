package com.yltx.appcn.main.my;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.ACache;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.GetUserInfoRsBean;
import com.yltx.appcn.bean.ResetPwdRsBean;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.Consta;

/**
 * Author：Wq
 * Date：2017/8/23 16:35
 * Description：//todo
 */

public class MyModel extends BaseModel implements MyContract.IMyModel {
    @Override
    public void doLoadData(Context context, String tag, String str,final MyContract.IMyPresenter mPresenter) {


        RxRetrofit.getInstance().getApiService().getUserInfoByUserId(str)
                .compose(((RxAppCompatActivity)context).<GetUserInfoRsBean>bindToLifecycle())
                .compose(RxSchedulers.<GetUserInfoRsBean>io_main())
                .subscribe(new NetObserver<GetUserInfoRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, GetUserInfoRsBean mGetUserInfoRsBean) {

                        mPresenter.loadResult(mGetUserInfoRsBean);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });


    }
}
