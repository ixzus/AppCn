package com.yltx.appcn.message;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * Author：Wq
 * Date：2017/8/21 20:31
 * Description：//todo  消息列表中的apapter
 */

public class MessageAdapter extends BaseQuickAdapter<GetMessagesRsBean.DataBean.MessagesBean, BaseViewHolder> {


    public MessageAdapter() {
        super(R.layout.item_message);
    }

    @Override
    protected void convert(BaseViewHolder helper,GetMessagesRsBean.DataBean.MessagesBean item) {
        helper.setText(R.id.tv_time, item.getSendTime());
        helper.setText(R.id.tv_messagetype, item.getTitle());
        helper.setText(R.id.tv_message, item.getBody());

    }
}
