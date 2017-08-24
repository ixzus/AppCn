package com.yltx.appcn.pwd;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperButton;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.ClearEditTextView;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.SendSmsRsBean;
import com.yltx.appcn.utils.ResultInfoUtils;
import com.yltx.appcn.widget.dialog.TimeCount;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType;
import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType_Modify;
import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType_ReSet;
import static com.yltx.appcn.utils.Consta.sendSmsData.PHONE;
import static com.yltx.appcn.utils.Consta.sendSmsData.Sms_Code;

/**
 * Author：Wq
 * Date：2017/8/21 16:56
 * Description：//todo
 */

@Route(path = "/pwd/FindPwdActivity")
public class FindPwdActivity extends BaseActivity<FindPwdContract.IFindPwdView, FindPwdPersenter> implements FindPwdContract.IFindPwdView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
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
                        toCheckNext();
                    }
                });




    }

    private void toNext() {

        ARouter.getInstance().build("/modifypwd/ModifyPwdActivity")
                .withInt(ModifyType, ModifyType_ReSet)
                .withString(Sms_Code,getSmsCode())
                .withString(PHONE,getPhone())
                .navigation(FindPwdActivity.this);
        finish();

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
        toNext();
    }

    private void toSendSms() {
        if(TextUtils.isEmpty(getPhone())||getPhone().length()!=11){
            //输入手机号
            Toasty.normal(FindPwdActivity.this, "请输入有效手机号!").show();
            return;
        }
        presenter.sendSms(FindPwdActivity.this, TAG,getPhone());
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
    public void onSendResult(SendSmsRsBean mSendSmsRsBean) {
        if(ResultInfoUtils.isSuccess(mSendSmsRsBean.getCode())){
            //发送验证码  返回结果
            //@// TODO: 2017/8/21  判断返回结果是否成功 成功 则倒计时开始
            new TimeCount(sbGetsms, 60 * 1000, 1000).start();
        }
        Toast.show(mSendSmsRsBean.getMessage());
    }

    @Override
    public void onCheckNextResult(String code) {
        
        //@// TODO: 2017/8/21  判断校验结果是否成功  成功则跳转重置密码页面

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }








}
