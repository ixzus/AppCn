package com.yltx.appcn.message;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * Author：Wq
 * Date：2017/8/21 20:16
 * Description：//todo
 */

public class MessagePersenter extends BasePresenter<MessageModel,MessageActivity> implements MessageContract.IMessagePresenter{
    @Override
    public void GetMessages(Context context, String tag, String json) {

        model.doGetMessages(context,tag,json,this);

    }

    @Override
    public void GetMessagesResult(GetMessagesRsBean.DataBean data) {

        view.onGetMessagesResult(data);

    }
}
