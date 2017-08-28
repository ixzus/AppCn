package com.yltx.appcn.base;

import android.app.ProgressDialog;
import android.os.Environment;
import android.support.v4.app.AbsDialog;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;
import com.google.gson.Gson;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.ViewHolder;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.UpGrade;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import zlc.season.rxdownload2.RxDownload;
import zlc.season.rxdownload2.entity.DownloadStatus;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/17.
 */

public class SplashActivity extends RxAppCompatActivity {
    private static final String TAG = "SplashActivity";
    private int countTime = 2;

    @Override
    protected void onResume() {
        super.onResume();
        loadData("1");
//        doCountTime();
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
//        ARouter.getInstance().build("/login/loginActivity").navigation(SplashActivity.this);
//        finish();

//        ARouter.getInstance().build("/app/MainActivity").navigation(SplashActivity.this);
//        finish();
        ARouter.getInstance().build("/order/OrderListActivity").navigation(SplashActivity.this);
//        ARouter.getInstance().build("/order/OrderDetailActivity").navigation(SplashActivity.this);
//        finish();
    }

    private void loadData(String versionCode) {
        RxRetrofit.getInstance().getApiService().findUpgrade(versionCode, "app", "cheguanjia")
                .compose(this.<UpGrade>bindToLifecycle())
                .compose(RxSchedulers.<UpGrade>io_main())
                .subscribe(new NetObserver<UpGrade>(this, TAG, 0, true) {

                    @Override
                    public void onSuccess(int whichRequest, final UpGrade result) {
                        if ("success".equals(result.getCode())) {
                            //升级
                            String strCancel = "N".equals(result.getBean().getIsforceupgrade()) ? "下次" : "退出";
                            ArrayList<String> listInfo = new ArrayList<String>();
                            listInfo.add(strCancel);
                            listInfo.add(result.getBean().getDescription());
                            ConfirmDialog.newInstance("版本更新", listInfo)
                                    .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                                        @Override
                                        public void convertView(ViewHolder holder, AbsDialog dialog) {
                                            dialog.dismiss();
                                            if ("Y".equals(result.getBean().getIsforceupgrade())) {
                                                finish();
                                            }
                                        }
                                    })
                                    .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                                        @Override
                                        public void convertView(ViewHolder holder, AbsDialog dialog) {
                                            dialog.dismiss();
                                            downLoad(result.getBean().getAppUrl());
                                        }
                                    })
                                    .setMargin(60)
                                    .setOutCancel(false)
                                    .show(getSupportFragmentManager());
                        } else {
                            Toast.show(result.getMessage());
                        }
                        Logger.e("" + new Gson().toJson(result));
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
                        Toast.show("初始化失败!");
                    }
                });
    }

    private ProgressDialog progressDialog;

    private void downLoad(final String url) {
        if (null == progressDialog) {
            progressDialog = new ProgressDialog(SplashActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setCancelable(false);

        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
        final String destFileName = Environment.getExternalStorageDirectory() + "chewuguanjia.apk";
        Disposable disposable = RxDownload.getInstance(this)
                .download(url)                       //只传url即可
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DownloadStatus>() {
                    @Override
                    public void accept(DownloadStatus status) throws Exception {
                        //DownloadStatus为下载进度
                        Logger.e("下载进度" + status.getPercent());
                        progressDialog.setProgress((int) status.getPercentNumber());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //下载失败
                        Logger.e("下载失败");
                        progressDialog.dismiss();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        //下载成功
                        Logger.e("下载成功");
                        File[] files = RxDownload.getInstance(SplashActivity.this).getRealFiles(url);
                        if (files != null) {
                            File file = files[0];
                            AppUtils.installApp(file, "com.blankj.androidutilcode.provider");
                        }
                        progressDialog.dismiss();
                    }
                });

//        RxRetrofit.getInstance().getApiService().downLoadFile(url)
//                .compose(this.<ResponseBody>bindToLifecycle())
//                .observeOn(Schedulers.computation())
//                .map(new Function<ResponseBody, File>() {
//                    @Override
//                    public File apply(@NonNull ResponseBody responseBody) throws Exception {
//                        return FileDownLoadObserver.saveFile(responseBody, Environment.getExternalStorageDirectory().getAbsolutePath(), "chewuguanjia.apk");
//                    }
//                })
//                .compose(RxSchedulers.<File>io_main())
//                .subscribe(new FileDownLoadObserver<File>() {
//                    @Override
//                    public void onDownLoadSuccess(File responseBody) {
//
//                    }
//
//                    @Override
//                    public void onDownLoadFail(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onProgress(int progress, long total) {
//                        Logger.e(""+progress);
//                    }
//                });

    }


}
