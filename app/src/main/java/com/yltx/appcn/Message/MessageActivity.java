package com.yltx.appcn.Message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2017/8/21 20:17
 * Description：//todo
 */

public class MessageActivity extends BaseActivity<MessageContract.IMessageView, MessagePersenter> implements MessageContract.IMessageView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_line)
    View toolbarLine;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private MessageAdapter adapter;

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
    }

    private void initRefresh() {
        presenter.GetMessage(MessageActivity.this,TAG,"");
    }

    private void initRv() {
        adapter = new MessageAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void retry() {

    }

    @Override
    public void onGetMessageResult(String code) {

        //@// TODO: 2017/8/21  判断是否成功  然后设置Adapter

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
