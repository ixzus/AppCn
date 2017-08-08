package com.yltx.appcn.net;

import android.content.Context;
import android.widget.Toast;

import java.io.EOFException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RxObserver<T> implements Observer<T> {


    private RxManager mRxManager;
    private int mWhichRequest;
    private String mKey;

    private boolean isShowDialog;
    private SweetAlertDialog mDialog;
    private Context mContext;


    public RxObserver(Context context, String key, int whichRequest, boolean isShowDialog) {
        this.mContext = context;
        this.mKey = key;
        this.isShowDialog = isShowDialog;
        this.mWhichRequest = whichRequest;
        mDialog = new SweetAlertDialog(context,SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setTitle("正在加载中...");

        mRxManager = RxManager.getInstance();
    }


    @Override
    public final void onSubscribe(Disposable d) {
        mRxManager.add(mKey, d);
        if (isShowDialog) {
            mDialog.show();
        }
        onStart(mWhichRequest);
    }

    @Override
    public final void onNext(T value) {
        onSuccess(mWhichRequest, value);
    }

    @Override
    public final void onError(Throwable e) {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
        if (e instanceof EOFException || e instanceof ConnectException || e instanceof SocketException || e instanceof BindException || e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
            Toast.makeText(mContext, "网络异常，请稍后重试！", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ApiException) {
            onError(mWhichRequest, e);
        } else {
            Toast.makeText(mContext, "未知错误！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public final void onComplete() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public abstract void onSuccess(int whichRequest, T t);

    public abstract void onError(int whichRequest, Throwable e);

    public void onStart(int whichRequest) {

    }

}