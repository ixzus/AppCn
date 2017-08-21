package com.yltx.appcn.pwd;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;

/**
 * Author：Wq
 * Date：2017/8/21 17:07
 * Description：//todo
 */

public class FindPwdModel extends BaseModel implements FindPwdContract.IFindPwdModel {
    @Override
    public void doSendSmsCode(Context context, String tag, String postJson, FindPwdContract.IFindPwdPresenter mPresenter) {

        //发送验证码

        //// TODO: 2017/8/21  发送验证验证码接口

//        mPresenter.sendSmsResult("");

    }

    @Override
    public void doCheckNext(Context context, String tag, String postJson, FindPwdContract.IFindPwdPresenter mPresenter) {
        //校验验证码
  //// TODO: 2017/8/21  校验验证验证码接口


//        mPresenter.checkNextResult("");



    }
}
