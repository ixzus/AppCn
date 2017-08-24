package com.yltx.appcn.cardetail;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.GetCarDetailRsBean;

/**
 * Author：Wq
 * Date：2017/8/22 10:56
 * Description：//todo
 */

public class CarDetailPresenter extends BasePresenter<CarDetailModel,CarDetailAvtivity> implements CarDetailContract.ICarDetailPresenter {
    @Override
    public void GetCarDetail(Context contex, String tag,String str) {

        model.GetCarDetail(contex,tag,str,this);

    }

    @Override
    public void GetCarDetailResult(GetCarDetailRsBean.DataBean data) {

        view.onGetCarDetailResult(data);

    }


}
