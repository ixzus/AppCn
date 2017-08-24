package com.yltx.appcn.cardetail;

import android.content.Context;

import com.google.gson.Gson;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.GetCarDetailRsBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.bean.SendSmsRsBean;
import com.yltx.appcn.login.LoginContract;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.ResultInfoUtils;

import static com.yltx.appcn.utils.Consta.sendSmsData.businessType;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class CarDetailModel extends BaseModel implements CarDetailContract.ICarDetailModel {

    @Override
    public void GetCarDetail(Context context, String tag, String str, final CarDetailContract.ICarDetailPresenter iLoginPresenter) {

        //获取车辆详情信息

        RxRetrofit.getInstance().getApiService().getCarInfoById(str)
                .compose(((RxAppCompatActivity)context).<GetCarDetailRsBean>bindToLifecycle())
                .compose(RxSchedulers.<GetCarDetailRsBean>io_main())
                .subscribe(new NetObserver<GetCarDetailRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, GetCarDetailRsBean mGetCarDetailRsBean) {
                        if(ResultInfoUtils.isSuccess(mGetCarDetailRsBean.getCode())){
//                            mPresenter.sendSmsResult(mSendSmsRsBean);
                            iLoginPresenter.GetCarDetailResult(mGetCarDetailRsBean.getData());
                        }
                        Toast.show(mGetCarDetailRsBean.getMessage());

                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        iLoginPresenter.loginResult(e.toString());
                    }
                });

    }
}
