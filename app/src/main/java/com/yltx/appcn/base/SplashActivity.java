package com.yltx.appcn.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

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

public class SplashActivity extends RxAppCompatActivity {
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

    private void goNext(){
//        ARouter.getInstance().build("/login/loginActivity").navigation(SplashActivity.this);
        ARouter.getInstance().build("/app/MainActivity").navigation(SplashActivity.this);
//        ARouter.getInstance().build("/order/OrderListActivity").navigation(SplashActivity.this);
        finish();
    }
}
