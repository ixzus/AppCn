package com.yltx.appcn.pwd;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.SendSmsRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class FindPwdContract {
    interface IFindPwdView extends BaseContract.IBaseView {
        String getPhone();

        String getSmsCode();

        void onSendResult(SendSmsRsBean mSendSmsRsBean);
        void onCheckNextResult(String code);
    }

    interface IFindPwdPresenter extends BaseContract.IBasePresenter {
        void sendSms(Context contex, String tag,String json);
        void  sendSmsResult(SendSmsRsBean mSendSmsRsBean);


        void checkNext(Context contex, String tag,String json);
        void checkNextResult(String resultJson);
    }

    interface IFindPwdModel extends BaseContract.IBaseModel {
        void doSendSmsCode(Context context, String tag, String postJson, IFindPwdPresenter mPresenter);//发送验证码
        void doCheckNext(Context context, String tag, String postJson, IFindPwdPresenter mPresenter);//下一步校验验证码
    }
}
