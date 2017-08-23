package com.yltx.appcn.modifypwd;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
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
import com.jingewenku.abrahamcaijin.commonutil.encryption.MD5Utils;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.base.SplashActivity;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;
import com.yltx.appcn.utils.ResultInfoUtils;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
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
 * Date：2017/8/22 9:49
 * Description：//todo
 */

@Route(path = "/modifypwd/ModifyPwdActivity")
public class ModifyPwdActivity extends BaseActivity<ModifyPwdContract.IModifyPwdView, ModifyPwdPersenter> implements ModifyPwdContract.IModifyPwdView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
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


    private int mModifyType;
    private String mPhone;
    private String mSmsCode;

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
        mModifyType=getIntent().getIntExtra(ModifyType,1);
        if(ModifyType_Modify ==mModifyType){
            //修改密码
            toolbar("修改密码密码", true, null);

        }else if(ModifyType_ReSet==mModifyType){

            toolbar("重置密码", true, null);
            //重置
            cetOld.setVisibility(View.GONE);
            mPhone=getIntent().getStringExtra(PHONE);
            mSmsCode=getIntent().getStringExtra(Sms_Code);

            Log.d(TAG,"==========mModifyType::"+mModifyType+"======mPhone:"+mPhone+"=====mSmsCode::"+mSmsCode);
        }

        RxView.clicks(b)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toCheck();
                    }
                });

    }

    private void toCheck() {

        if(ModifyType_Modify ==mModifyType){
            //修改密码

        }else if(ModifyType_ReSet==mModifyType){
            //重置

            if(TextUtils.isEmpty(getNew())){
                Toast.show("输入新密码不能为空！");
                return;
            }
            if(TextUtils.isEmpty(getComfire())){
                Toast.show("输入确认密码不能为空!");
                return;
            }

            if(!getNew().equals(getComfire())){
                Toast.show("两次输入密码不一致!");
                return;
            }
            ResetPwdBean mResetPwdBean=new ResetPwdBean();
            mResetPwdBean.setPhone(mPhone);
            mResetPwdBean.setCode(mSmsCode);
            mResetPwdBean.setNewPassword(MD5Utils.encryptMD5(getNew()));
            presenter.ResetPwd(ModifyPwdActivity.this,TAG,mResetPwdBean);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void retry() {

    }

    @Override
    public String getOld() {
        return cetOld.getText().toString().trim();
    }

    @Override
    public String getNew() {
        return cetNew.getText().toString().trim();
    }

    @Override
    public String getComfire() {
        return cetComfire.getText().toString().trim();
    }

    @Override
    public void onModifyPwdResult(String code) {

    }

    @Override
    public void onResetPwdResult(ResetPwdRsBean mResetPwdRsBean) {
        if(null!=mResetPwdRsBean&& ResultInfoUtils.isSuccess(mResetPwdRsBean.getCode())){
            ARouter.getInstance().build("/login/loginActivity").navigation(ModifyPwdActivity.this);//登录页面
            finish();
        }
        Toast.show(mResetPwdRsBean.getMessag());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
