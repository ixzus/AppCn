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

        String str="从历史和现实、理论和实践、国内和国际等的结合上进行思考，从我国社会发展的历史方位上来思考，" +
                "从党和国家事业发展大局出发进行思考，得出正确结论。”他指出，“全党要牢牢把握社会主义初级阶段这个最大国情，" +
                "牢牢立足社会主义初级阶段这个最大实际，更准确地把握我国社会主义初级阶段不断变化的特点，坚持党的基本路线，" +
                "在继续推动经济发展的同时，更好解决我国社会出现的各种问题，更好实现各项事业全面发展，更好发展中国特色社会" +
                "主义事业，更好推动人的全面发展、社会全面进步。”";
        helper.setText(R.id.tv_time, item.getSendTime());
        helper.setText(R.id.tv_messagetype, item.getTitle());
        helper.setText(R.id.tv_message, item.getBody()+str);

    }
}
