package com.yltx.appcn.pwd;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.widget.ClearEditTextView;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.widget.dialog.TimeCount;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Author：Wq
 * Date：2017/8/21 16:56
 * Description：//todo
 */

@Route(path = "/modifypwd/FindPwdActivity")
public class FindPwdActivity extends BaseActivity<FindPwdContract.IFindPwdView, FindPwdPersenter> implements FindPwdContract.IFindPwdView, IToolbar {
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
    @BindView(R.id.cet_phone)
    ClearEditTextView cetPhone;
    @BindView(R.id.cet_sms)
    ClearEditTextView cetSms;
    @BindView(R.id.sb_getsms)
    SuperButton sbGetsms;
    @BindView(R.id.sb_next)
    SuperButton sbNext;

    @Override
    protected FindPwdPersenter initPresenter() {
        return new FindPwdPersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new FindPwdModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_findpwd;
    }

    @Override
    protected void initView() {
        toolbar("找回密码", true, null);
        //@// TODO: 2017/8/21 发送验证码
        RxView.clicks(sbGetsms)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toSendSms();
                    }
                });

        //@// TODO: 2017/8/21 点击下一步 校验验证码
        RxView.clicks(sbNext)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
//                       presenter.checkNext(FindPwdActivity.this, TAG);
                        toCheckNext();//点击下一步校验验证码
                    }
                });




    }

    private void toCheckNext() {
        if(TextUtils.isEmpty(getPhone())||getPhone().length()!=11){
            //输入手机号
            Toasty.normal(FindPwdActivity.this, "请输入有效手机号!").show();
            return;
        }

        if(TextUtils.isEmpty(getSmsCode())){
            Toasty.normal(FindPwdActivity.this, "输入验证码不能为空!").show();
            return;
        }

        presenter.checkNext(FindPwdActivity.this, TAG,"");
    }

    private void toSendSms() {
        if(TextUtils.isEmpty(getPhone())||getPhone().length()!=11){
            //输入手机号
            Toasty.normal(FindPwdActivity.this, "请输入有效手机号!").show();
            return;
        }
        presenter.sendSms(FindPwdActivity.this, TAG,"");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void retry() {

    }

    @Override
    public String getPhone() {
        return cetPhone.getText().toString().trim();
    }

    @Override
    public String getSmsCode() {
        return cetSms.getText().toString().trim();
    }

    @Override
    public void onSendResult(String code) {

                //发送验证码  返回结果
        //@// TODO: 2017/8/21  判断返回结果是否成功 成功 则倒计时开始
        new TimeCount(sbGetsms, 60 * 1000, 1000).start();

    }

    @Override
    public void onCheckNextResult(String code) {
        
        //@// TODO: 2017/8/21  判断校验结果是否成功  成功则跳转重置密码页面

    }

//    @Override
//    public void onSendResult(String code) {
//        //发送验证码  返回结果
//        //发送验码成功,开启倒计时
//        new TimeCount(sbGetsms, 60 * 1000, 1000).start();
//    }
//
//    @Override
//    public void onCheckNextResult(String code) {
//        //校验验证码返回结果
//
//
//        //成功跳转下一个页面
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }






}
