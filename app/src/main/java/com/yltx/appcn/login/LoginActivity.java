package com.yltx.appcn.login;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yltx.appcn.R;
import com.example.applibrary.base.BaseActivity;
import com.example.applibrary.base.BaseModel;

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter> implements LoginContract.ILoginView, View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    protected void initView() {
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
                final SpringAnimation anim = new SpringAnimation(mButton ,SpringAnimation.TRANSLATION_Y).setSpring(spring);
                anim.cancel();
                anim.setStartValue(-700);
                anim.start();
                break;
        }
    }
}
