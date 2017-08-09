package com.yltx.appcn.net;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.NetworkUtils;
import com.ixzus.applibrary.net.RxManager;
import com.yltx.appcn.base.App;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class NetObserver<T> implements Observer<T> {

    private final int RESPONSE_CODE_OK = 200;      //自定义的业务逻辑，成功返回积极数据
    private final int RESPONSE_CODE_FAILED = -1; //返回数据失败

    private RxManager mRxManager;
    private int mWhichRequest;
    private String mKey;

    private boolean isShowDialog = true;
    private SweetAlertDialog mDialog;
    private Context mContext;


    public NetObserver(Context context, String key, int whichRequest, boolean isShowDialog) {
        this.mContext = context;
        this.mKey = key;
        this.isShowDialog = isShowDialog;
        this.mWhichRequest = whichRequest;
        if (isShowDialog) {
            mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            mDialog.setTitleText("正在加载中...");
            mDialog.setCancelable(false);
        }

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
    public final void onNext(T response) {
        onSuccess(mWhichRequest, response);
//        if (response.getCode() == RESPONSE_CODE_OK) {
//            onSuccess(mWhichRequest, response.getResult());
//        } else {
//            onFailure(response.getCode(), response.getError());
//        }
    }

    public void onFailure(int code, String message) {
        if (code == RESPONSE_CODE_FAILED && mContext != null) {
//            HttpUiTips.alertTip(mContext, message, code);
        } else {
            disposeEorCode(message, code);
        }
    }

    private final void disposeEorCode(String message, int code) {
        switch (code) {
            case 101:
            case 112:
            case 123:
            case 401:
                //退回到登录页面
                ARouter.getInstance().build("/app/MainActivity").navigation();
                break;
        }
//        Toast.makeText(mContext, message + " # " + code, Toast.LENGTH_SHORT).show();
    }

    @Override
    public final void onError(Throwable t) {
        if (isShowDialog && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        int code = 0;
        String errorMessage = "未知错误";
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            String meg = httpException.response().toString();   //
            code = httpException.code();
            errorMessage = httpException.getMessage();
        } else if (t instanceof SocketTimeoutException) {  //VPN open
            code = RESPONSE_CODE_FAILED;
            errorMessage = "服务器响应超时";
        } else if (t instanceof ConnectException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "网络连接异常，请检查网络";
        } else if (t instanceof RuntimeException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "运行时错误";
        } else if (t instanceof UnknownHostException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "无法解析主机，请检查网络连接";
        } else if (t instanceof UnknownServiceException) {
            code = RESPONSE_CODE_FAILED;
            errorMessage = "未知的服务器错误";
        } else if (t instanceof IOException) {  //飞行模式等
            code = RESPONSE_CODE_FAILED;
            errorMessage = "没有网络，请检查网络连接";
        }

        /**
         * 严重的错误弹出dialog，一般的错误就只要Toast
         */
//        if (RESPONSE_CODE_FAILED == code) {
//            onFailure(RESPONSE_CODE_FAILED, errorMessage);
//        } else {
//            if (mContext != null && !((Activity) mContext).isFinishing()) {
//                Toast.makeText(mContext, errorMessage + " - " + code, Toast.LENGTH_SHORT).show();
//            }
//        }
        onFailure(code, errorMessage);
    }

    @Override
    public final void onComplete() {
        if (isShowDialog && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public abstract void onSuccess(int whichRequest, T t);

    public abstract void onError(int whichRequest, Throwable e);

    public void onStart(int whichRequest) {
//        if (!NetworkUtil.isNetworkAvailable(context)) {
        if (!NetworkUtils.isAvailableByPing()) {

            Toast.makeText(App.getApplication(), "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            NetworkUtils.openWirelessSettings();
//            if (isNeedCahe) {
//                //无网络已经读取缓存
//            }
            // **一定要主动调用下面这一句**
            onComplete();
            return;
        }
        // 显示进度条
        if (isShowDialog && isShowDialog) {
            mDialog.show();
        }

    }

}