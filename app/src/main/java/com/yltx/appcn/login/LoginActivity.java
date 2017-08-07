package com.yltx.appcn.login;

import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.constant.ViewStatus;
import com.ixzus.applibrary.impl.IActivity;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;
import com.yltx.appcn.base.App;

import es.dmoral.toasty.Toasty;

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter>
        implements LoginContract.ILoginView, View.OnClickListener, IActivity, IToolbar, ISwipeBack {

    private Button mButton;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        toolbar("菜单", true, "主页");
        showStatus(ViewStatus.STATUS_LOADING);
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
    public String getPostJson() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void onLoginResult(String code) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                SpringForce spring = new SpringForce(0)
                        .setDampingRatio(0.05f)
                        .setStiffness(SpringForce.STIFFNESS_VERY_LOW);
                final SpringAnimation anim = new SpringAnimation(mButton, SpringAnimation.TRANSLATION_Y).setSpring(spring);
                anim.cancel();
                anim.setStartValue(-700);
                anim.start();
                break;
        }
    }


    @Override
    public void retry() {
        Toasty.normal(App.getApplication(), "重试").show();
    }
}
