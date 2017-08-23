package com.yltx.appcn.main.my;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.GetUserInfoRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class MyContract {
    interface IMyView extends BaseContract.IBaseView {
        void onResult(GetUserInfoRsBean mGetUserInfoRsBean);
    }

    interface IMyPresenter extends BaseContract.IBasePresenter {
        void loadData(Context contex, String tag);

        void loadResult(GetUserInfoRsBean mGetUserInfoRsBean);
    }

    interface IMyModel extends BaseContract.IBaseModel {
        void doLoadData(Context context, String tag,IMyPresenter mIMyPresenter);
    }
}
