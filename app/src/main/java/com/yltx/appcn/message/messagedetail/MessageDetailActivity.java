package com.yltx.appcn.message.messagedetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.GetMessagesRsBean;
import com.yltx.appcn.utils.Consta;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2017/8/24 14:56
 * Description：//todo
 */

@Route(path = "/message/messagedetail/MessageDetailActivity")
public class MessageDetailActivity extends BaseActivity<MessageDetailContract.IMessageDetailView, MessageDetailPresenter> implements MessageDetailContract.IMessageDetailView {


    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_message_title)
    TextView tvMessageTitle;
    @BindView(R.id.tv_message_time)
    TextView tvMessageTime;
    @BindView(R.id.tv_message_content)
    TextView tvMessageContent;
    private GetMessagesRsBean.DataBean.MessagesBean bean;

    @Override
    protected MessageDetailPresenter initPresenter() {
        return new MessageDetailPresenter();
    }

    @Override
    protected BaseModel initModule() {
        return new MessageDetailModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_meaasgedetail;
    }

    @Override
    protected void initView() {
        toolbar("消息详情", true, null);

    }

    @Override
    protected void initData() {
        bean = (GetMessagesRsBean.DataBean.MessagesBean) getIntent().getSerializableExtra(Consta.SP_PARAMS.MESSAGE_BODY);
        setData();
    }

    private void setData() {

        String testStr="-----从历史和现实、理论和实践、国内和国际等的结合上进行思考，从我国社会发展的历史方位上来思考，" +
                "从党和国家事业发展大局出发进行思考，得出正确结论。”他指出，“全党要牢牢把握社会主义初级阶段这个最大国情，" +
                "牢牢立足社会主义初级阶段这个最大实际，更准确地把握我国社会主义初级阶段不断变化的特点，坚持党的基本路线，" +
                "在继续推动经济发展的同时，更好解决我国社会出现的各种问题，更好实现各项事业全面发展，更好发展中国特色社会" +
                "主义事业，更好推动人的全面发展、社会全面进步。”";
        tvMessageTitle.setText(bean.getTitle());
        tvMessageTime.setText(bean.getSendTime());
        tvMessageContent.setText(bean.getBody()+testStr);
    }

    @Override
    public void retry() {

    }

    @Override
    public void onGetMessageDetailResult(GetMessagesRsBean.DataBean data) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
