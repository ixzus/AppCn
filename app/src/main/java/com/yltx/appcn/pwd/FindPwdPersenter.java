package com.yltx.appcn.pwd;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;

/**
 * Author：Wq
 * Date：2017/8/21 17:06
 * Description：//todo
 */

public class FindPwdPersenter extends BasePresenter<FindPwdModel,FindPwdActivity> implements FindPwdContract.IFindPwdPresenter{


    @Override
    public void sendSms(Context context, String tag,String json) {

        model.doSendSmsCode(context,tag,json,this);

    }

    @Override
    public void sendSmsResult(String resultJson) {
        view.onSendResult(resultJson);

    }

    @Override
    public void checkNext(Context context, String tag,String json) {
        model.doCheckNext(context,tag,json,this);
    }

    @Override
    public void checkNextResult(String resultJson) {
        view.onCheckNextResult(resultJson);

    }
}
