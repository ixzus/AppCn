package com.yltx.appcn.Message;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class MessageContract {
    interface IMessageView extends BaseContract.IBaseView {
        void onGetMessageResult(String code);
    }
    interface IMessagePresenter extends BaseContract.IBasePresenter {
        void GetMessage(Context contex, String tag, String json);
        void  GetMessageResult(String resultJson);
    }
    interface IMessageModel extends BaseContract.IBaseModel {
        void doGetMessage(Context context, String tag, String postJson, IMessagePresenter mPresenter);//发送验证码
    }
}
