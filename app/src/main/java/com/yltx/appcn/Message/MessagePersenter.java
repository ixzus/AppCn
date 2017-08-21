package com.yltx.appcn.Message;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;

/**
 * Author：Wq
 * Date：2017/8/21 20:16
 * Description：//todo
 */

public class MessagePersenter extends BasePresenter<MessageModel,MessageActivity> implements MessageContract.IMessagePresenter{
    @Override
    public void GetMessage(Context context, String tag, String json) {

        model.doGetMessage(context,tag,json,this);

    }

    @Override
    public void GetMessageResult(String resultJson) {

    }
}
