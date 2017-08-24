package com.yltx.appcn.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperButton;
import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.constant.ViewStatus;
import com.ixzus.applibrary.impl.IActivity;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.util.ACache;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.ClearEditTextView;
import com.ixzus.applibrary.widget.ViewHolder;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.LoginRsBean;
import com.yltx.appcn.modifypwd.ModifyPwdActivity;
import com.yltx.appcn.utils.Consta;
import com.yltx.appcn.utils.ResultInfoUtils;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter>
        implements LoginContract.ILoginView, IActivity, IToolbar, ISwipeBack {


    @BindView(R.id.button)
    SuperButton button;
    @BindView(R.id.button1)
    SuperButton button1;
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.cet_inputphone)
    ClearEditTextView cetInputphone;
    @BindView(R.id.cet_inputpwde)
    ClearEditTextView cetInputpwde;
    @BindView(R.id.tv_forgot)
    TextView tvForgot;
    @BindView(R.id.cb_rember)
    CheckBox cbRember;
    @BindView(R.id.tv_repwd)
    TextView tvRepwd;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        toolbar("登录", false, null);

        showStatus(ViewStatus.STATUS_LOADING);

        RxView.clicks(button)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toLogin();
                    }
                });
        RxView.clicks(button1)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        ConfirmDialog.newInstance("2")
                                .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                                    @Override
                                    public void convertView(ViewHolder holder, AbsDialog dialog) {
                                        Toast.makeText(LoginActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                                    @Override
                                    public void convertView(ViewHolder holder, AbsDialog dialog) {
                                        Toasty.normal(LoginActivity.this, "kkkkkkkkk").show();
                                        dialog.dismiss();
                                    }
                                })
                                .setMargin(34)
                                .setOutCancel(false)
                                .setAnimStyle(R.style.DialogAnimation)
                                .show(getSupportFragmentManager());
                    }
                });


        //@// TODO: 2017/8/22  忘记密码
        RxView.clicks(tvForgot)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toForgot();
                    }
                });


        //@// TODO: 2017/8/22  记住密码密码
        RxView.clicks(tvRepwd)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toRemenber();
                    }
                });

        //@// TODO: 2017/8/22  记住密码密码
        RxView.clicks(ivTitle)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toSetting();
                    }
                });
    }

    private void toLogin() {
//        cetInputphone.setText("13510378755");
//        cetInputpwde.setText("123456");
        if (TextUtils.isEmpty(getName())) {
            Toast.makeText(LoginActivity.this, "输入手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(getPwd())) {
            Toast.makeText(LoginActivity.this, "输入密码不能为空", Toast.LENGTH_SHORT).show();
            return;

        }
        presenter.login(LoginActivity.this, TAG);
    }

    private void toSetting() {

        ARouter.getInstance().build("/other/SettingActivity").navigation(LoginActivity.this);
        finish();

    }

    private void toRemenber() {

        ARouter.getInstance().build("/message/MessageActivity").navigation(LoginActivity.this);
        finish();
    }

    private void toForgot() {


        ARouter.getInstance().build("/pwd/FindPwdActivity").navigation(LoginActivity.this);
        finish();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BaseModel initModule() {
        return new LoginModel();
    }

    @Override
    protected LoginPersenter initPresenter() {
        return new LoginPersenter();
    }


    @Override
    public String getName() {
        return cetInputphone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return cetInputpwde.getText().toString().trim();
    }


    private void toNext() {
        ARouter.getInstance().build("/app/MainActivity").navigation(LoginActivity.this);
        finish();
    }

    @Override
    public void onLoginResult(LoginRsBean mLoginRsBean) {
        Log.d(TAG,"==================onLoginResult::"+new Gson().toJson(mLoginRsBean));
        if (ResultInfoUtils.isSuccess(mLoginRsBean.getCode())) {
           // ACache.get(this).put(Consta.SP_PARAMS.USERID,mLoginRsBean.getUserId());
            if(null!=mLoginRsBean.getData()){
                ACache.get(this).put(Consta.SP_PARAMS.USERID,mLoginRsBean.getData().getUserId());
            }
            toNext();
        }
        Toast.makeText(LoginActivity.this, mLoginRsBean.getMessage(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void retry() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
