package com.yltx.appcn.message;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.GetMessagesRsBean;
import com.yltx.appcn.message.messagedetail.MessageDetailActivity;
import com.yltx.appcn.pwd.FindPwdActivity;
import com.yltx.appcn.utils.Consta;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;


import static com.yltx.appcn.utils.Consta.INTENT_KEY_PARAMS.MESSAGE_BODY;
import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType;
import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType_ReSet;
import static com.yltx.appcn.utils.Consta.sendSmsData.PHONE;
import static com.yltx.appcn.utils.Consta.sendSmsData.Sms_Code;

/**
 * Author：Wq
 * Date：2017/8/21 20:17
 * Description：//todo
 */
@Route(path = "/message/MessageActivity")
public class MessageActivity extends BaseActivity<MessageContract.IMessageView, MessagePersenter> implements MessageContract.IMessageView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private MessageAdapter adapter;

    private int startPage=1;

    private ArrayList<String> mList;

    private List<GetMessagesRsBean.DataBean.MessagesBean> messages=new ArrayList<GetMessagesRsBean.DataBean.MessagesBean>();

    @Override
    protected MessagePersenter initPresenter() {
        return new MessagePersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new MessageModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
        toolbar("消息", true, null);


    }

    @Override
    protected void initData() {
        initRv();
        initRefresh();
        initEvent();
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GetMessagesRsBean.DataBean.MessagesBean bean=messages.get(position);
                if(Consta.MESSAGE_TYPE.MESSAGE_TYPE_SYSTEM.equals(bean.getMessageType())){
                    //跳转 订单详情页面

                }else if(Consta.MESSAGE_TYPE.MESSAGE_TYPE_ORDER.equals(bean.getMessageType())){
                    //系统消息 跳转MessageDetailActivity页面
                    ARouter.getInstance().build("/message/messagedetail/MessageDetailActivity")
                            .withSerializable(MESSAGE_BODY,bean)
                            .navigation(MessageActivity.this);
                }
            }
        });
    }

    private void toNext() {
        //@// TODO: 2017/8/22  测试跳转 车辆详情 
        ARouter.getInstance().build("/cardetail/CarDetailAvtivity").navigation(MessageActivity.this);
        finish();

    }

    private void initRefresh() {
        presenter.GetMessages(MessageActivity.this, TAG, startPage+"");
    }

    private void initRv() {

//        mList = new ArrayList<String>();
//        for (int i = 0; i < 50; i++) {
//            mList.add("哈哈哈哈哈哈" + i);
//        }

        adapter = new MessageAdapter();
        adapter.setNewData(messages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void retry() {

    }

    @Override
    public void onGetMessagesResult(GetMessagesRsBean.DataBean data) {

        //@// TODO: 2017/8/21  判断是否成功  然后设置Adapter
        messages=data.getMessages();
        adapter.setNewData(messages);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
