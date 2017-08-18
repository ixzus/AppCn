package com.yltx.appcn.login;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.constant.ViewStatus;
import com.ixzus.applibrary.impl.IActivity;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginContract.ILoginView, LoginPersenter>
        implements LoginContract.ILoginView, IActivity, IToolbar, ISwipeBack {


    @BindView(R.id.button)
    SuperButton button;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        toolbar("首页", false, null, R.color.white, R.color.text_black);
        showStatus(ViewStatus.STATUS_LOADING);
        RxView.clicks(button)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        presenter.login(LoginActivity.this, TAG);
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
    public String getName() {
        return "13510378755";
    }

    @Override
    public String getPwd() {
        return "e10adc3949ba59abbe56e057f20f883e";
    }

    @Override
    public void onLoginResult(String code) {
    }

    @Override
    public void retry() {
    }

}
