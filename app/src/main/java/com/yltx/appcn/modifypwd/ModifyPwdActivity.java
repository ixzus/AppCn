package com.yltx.appcn.modifypwd;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.widget.ClearEditTextView;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2017/8/22 9:49
 * Description：//todo
 */

@Route(path = "/modifypwd/ModifyPwdActivity")
public class ModifyPwdActivity extends BaseActivity<ModifyPwdContract.IModifyPwdView, ModifyPwdPersenter> implements ModifyPwdContract.IModifyPwdView, IToolbar {
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
    @BindView(R.id.cet_old)
    ClearEditTextView cetOld;
    @BindView(R.id.cet_new)
    ClearEditTextView cetNew;
    @BindView(R.id.cet_comfire)
    ClearEditTextView cetComfire;
    @BindView(R.id.b)
    SuperButton b;

    @Override
    protected ModifyPwdPersenter initPresenter() {
        return new ModifyPwdPersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new ModifyPwdModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_modifypwd;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void retry() {

    }

    @Override
    public String getOld() {
        return null;
    }

    @Override
    public String getNew() {
        return null;
    }

    @Override
    public String getComfire() {
        return null;
    }

    @Override
    public void onModifyPwdResult(String code) {

    }

    @Override
    public void onResetPwdResult(String code) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
