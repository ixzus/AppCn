package com.yltx.appcn.cardetail;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.GetCarDetailRsBean;

import static android.R.attr.data;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class CarDetailContract {
    interface ICarDetailView extends BaseContract.IBaseView {
        void onGetCarDetailResult(GetCarDetailRsBean.DataBean data);
    }

    interface ICarDetailPresenter extends BaseContract.IBasePresenter {
        void GetCarDetail(Context contex, String tag,String str);

        void GetCarDetailResult(GetCarDetailRsBean.DataBean data);
    }

    interface ICarDetailModel extends BaseContract.IBaseModel {
        void GetCarDetail(Context context, String tag, String postJson, ICarDetailPresenter iLoginPresenter);
    }
}
