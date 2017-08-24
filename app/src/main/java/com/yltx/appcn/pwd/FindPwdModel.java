package com.yltx.appcn.pwd;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.LoginRsBean;
import com.yltx.appcn.bean.SendSmsRsBean;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.ResultInfoUtils;

import static com.yltx.appcn.utils.Consta.sendSmsData.businessType;

/**
 * Author：Wq
 * Date：2017/8/21 17:07
 * Description：//todo
 */

public class FindPwdModel extends BaseModel implements FindPwdContract.IFindPwdModel {
    @Override
    public void doSendSmsCode(Context context, String tag, String postJson, final FindPwdContract.IFindPwdPresenter mPresenter) {

        //发送验证码

        //// TODO: 2017/8/21  发送验证验证码接口

        RxRetrofit.getInstance().getApiService().sendMsgByPhone(postJson,businessType)
                .compose(((RxAppCompatActivity)context).<SendSmsRsBean>bindToLifecycle())
                .compose(RxSchedulers.<SendSmsRsBean>io_main())
                .subscribe(new NetObserver<SendSmsRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, SendSmsRsBean mSendSmsRsBean) {
                        if(ResultInfoUtils.isSuccess(mSendSmsRsBean.getCode())){
                            mPresenter.sendSmsResult(mSendSmsRsBean);
                        }
                        Toast.show(mSendSmsRsBean.getMessage());

                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });

    }

    @Override
    public void doCheckNext(Context context, String tag, String postJson, FindPwdContract.IFindPwdPresenter mPresenter) {
        //校验验证码
  //// TODO: 2017/8/21  校验验证验证码接口


//        mPresenter.checkNextResult("");



    }
}
