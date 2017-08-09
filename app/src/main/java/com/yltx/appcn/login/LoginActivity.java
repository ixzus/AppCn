package com.yltx.appcn.login;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.constant.ViewStatus;
import com.ixzus.applibrary.impl.IActivity;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.net.RxSchedulers;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.base.App;
import com.yltx.appcn.bean.CartMemberBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.net.NetObserver;
import com.yltx.appcn.net.RxRetrofit;

import java.util.concurrent.TimeUnit;

import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter>
        implements LoginContract.ILoginView, View.OnClickListener, IActivity, IToolbar, ISwipeBack {

    private Button mButton;
    private TextView textView;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textview);
        mButton.setOnClickListener(this);
        toolbar("菜单", true, "主页");
        showStatus(ViewStatus.STATUS_LOADING);
        RxView.clicks(mButton)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        loadData();
                    }
                });
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
//                SpringForce spring = new SpringForce(0)
//                        .setDampingRatio(0.05f)
//                        .setStiffness(SpringForce.STIFFNESS_VERY_LOW);
//                final SpringAnimation anim = new SpringAnimation(mButton, SpringAnimation.TRANSLATION_Y).setSpring(spring);
//                anim.cancel();
//                anim.setStartValue(-700);
//                anim.start();
                loadData();
                break;
        }
    }

    private void loadData() {
        String json = " {\"accountName\":\"13510378755\", \n" +
                "                                         \"cordova\":\"1.2.2\", \n" +
                "                                         \"ip\":\"\", \n" +
                "                                         \"loginChannel\":\"Android\", \n" +
                "                                         \"loginType\":\"mobilePhone\", \n" +
                "                                         \"model\":\"HUAWEI MT7-L09\", \n" +
                "                                         \"password\":\"e10adc3949ba59abbe56e057f20f883e\", \n" +
                "                                         \"platform\":\"Android\", \n" +
                "                                         \"reference\":\"cheguanjia\", \n" +
                "                                         \"uuid\":\"865276021651906\", \n" +
                "                                         \"version\":\"Huawei\"} ";
        LoginInfo loginInfo = new Gson().fromJson(json, LoginInfo.class);
//        RxRetrofit.getInstance().getApiService().getMemger("4983400")
        RxRetrofit.getInstance().getApiService().login(loginInfo)
//                .compose(bindUntilEvent(ActivityEvent.PAUSE))
                .compose(this.<Member>bindToLifecycle())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxSchedulers.<Member>io_main())
                .subscribe(new NetObserver<Member>(LoginActivity.this, TAG, 0, true) {

                    @Override
                    public void onSuccess(int whichRequest, Member member) {
                        textView.setText(new Gson().toJson(member));
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        textView.setText(e.toString());
                    }
                });
        RxRetrofit.getInstance().getApiService().getMemger("4983400")
//                .compose(bindUntilEvent(ActivityEvent.PAUSE))
                .compose(this.<CartMemberBean>bindToLifecycle())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxSchedulers.<CartMemberBean>io_main())
                .subscribe(new NetObserver<CartMemberBean>(LoginActivity.this, TAG, 0, false) {

                    @Override
                    public void onSuccess(int whichRequest, CartMemberBean member) {
                        textView.setText(new Gson().toJson(member));
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        textView.setText(e.toString());
                    }
                });

    }


    @Override
    public void retry() {
        Toasty.normal(App.getApplication(), "重试").show();
    }

}
