package com.yltx.appcn.modifypwd;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.ModifyPwdBean;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;
import com.yltx.appcn.bean.SendSmsRsBean;
import com.yltx.appcn.net.RxRetrofit;

import static com.yltx.appcn.utils.Consta.sendSmsData.businessType;

/**
 * Author：Wq
 * Date：2017/8/22 9:47
 * Description：//todo
 */

public class ModifyPwdModel extends BaseModel implements ModifyPwdContract.IModifyPwdModel {
    @Override
    public void doModifyPwd(Context context, String tag, ModifyPwdBean mModifyPwdBean, final ModifyPwdContract.IModifyPwdPresenter mPresenter) {
        //@// TODO: 2017/8/22  修改密码

//        RxRetrofit.getInstance().getApiService().updatePassword(mModifyPwdBean)
//                .compose(((RxAppCompatActivity)context).<String>bindToLifecycle())
//                .compose(RxSchedulers.<String>io_main())
//                .subscribe(new NetObserver<String>(context, tag, 0, true) {
//                    @Override
//                    public void onSuccess(int whichRequest, String string) {
//
//                        mPresenter.ModifyPwdResult(string);
//                    }
//
//                    @Override
//                    public void onError(int whichRequest, Throwable e) {
////                        iLoginPresenter.loginResult(e.toString());
//                    }
//                });

        RxRetrofit.getInstance().getApiService().updatePassword(mModifyPwdBean.getUserId(),mModifyPwdBean.getOldPassword(),mModifyPwdBean.getNewPassword())
                .compose(((RxAppCompatActivity)context).<ResetPwdRsBean>bindToLifecycle())
                .compose(RxSchedulers.<ResetPwdRsBean>io_main())
                .subscribe(new NetObserver<ResetPwdRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, ResetPwdRsBean mResetPwdRsBean) {
                        mPresenter.ModifyPwdResult(mResetPwdRsBean);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });


    }

    @Override
    public void doResetPwd(Context context, String tag, ResetPwdBean mResetPwdBean, final ModifyPwdContract.IModifyPwdPresenter mPresenter) {
        //@// TODO: 2017/8/22  重置密码


        RxRetrofit.getInstance().getApiService().resetnewPassword(mResetPwdBean)
                .compose(((RxAppCompatActivity)context).<ResetPwdRsBean>bindToLifecycle())
                .compose(RxSchedulers.<ResetPwdRsBean>io_main())
                .subscribe(new NetObserver<ResetPwdRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, ResetPwdRsBean mResetPwdRsBean) {

                        mPresenter.ResetPwdResult(mResetPwdRsBean);
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });


        

    }
}
