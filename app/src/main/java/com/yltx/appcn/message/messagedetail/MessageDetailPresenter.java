package com.yltx.appcn.message.messagedetail;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * Author：Wq
 * Date：2017/8/24 14:58
 * Description：//todo
 */

public class MessageDetailPresenter extends BasePresenter<MessageDetailModel,MessageDetailActivity> implements  MessageDetailContract.IMessageDetailPresenter{
    @Override
    public void GetMessageDetail(Context contex, String tag, String json) {

        model.doGetMessageDetail(contex,tag,"",this);

    }

    @Override
    public void GetMessageDetailResult(GetMessagesRsBean.DataBean data) {

    }
}
