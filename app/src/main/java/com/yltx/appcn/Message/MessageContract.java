package com.yltx.appcn.message;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class MessageContract {
    interface IMessageView extends BaseContract.IBaseView {
        void onGetMessagesResult(String code);
    }
    interface IMessagePresenter extends BaseContract.IBasePresenter {
        void GetMessages(Context contex, String tag, String json);
        void  GetMessagesResult(String resultJson);
    }
    interface IMessageModel extends BaseContract.IBaseModel {
        void doGetMessages(Context context, String tag, String postJson, IMessagePresenter mPresenter);//发送验证码
    }
}
