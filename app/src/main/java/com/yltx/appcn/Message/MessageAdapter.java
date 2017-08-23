package com.yltx.appcn.message;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.appcn.R;

/**
 * Author：Wq
 * Date：2017/8/21 20:31
 * Description：//todo  消息列表中的apapter
 */

public class MessageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public MessageAdapter() {
        super(R.layout.item_message);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_time, item);
    }
}
