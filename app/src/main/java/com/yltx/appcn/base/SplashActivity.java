package com.yltx.appcn.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/17.
 */

public class SplashActivity extends BaseActivity<Contract.IView, Persenter>
        implements Contract.IView {
    private int countTime = 2;

    @Override
    protected void onResume() {
        super.onResume();
        doCountTime();
    }

    private void doCountTime() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(countTime + 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(@NonNull Long aLong) throws Exception {
                        return countTime - aLong;
                    }
                })
                .compose(this.<Long>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {

                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Logger.e("" + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        goNext();
                    }
                });
    }

    private void goNext() {
//        ARouter.getInstance().build("/app/MainActivity").navigation(SplashActivity.this);
        ARouter.getInstance().build("/login/loginActivity").navigation(SplashActivity.this);
        finish();
    }

    @Override
    public void retry() {

    }

    @Override
    public String getJson() {
        return null;
    }

    @Override
    public void onResult(String code) {

    }

    @Override
    protected Persenter initPresenter() {
        return new Persenter();
    }

    @Override
    protected BaseModel initModule() {
        return new Model();
    }

    @Override
    protected int initLayout() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
