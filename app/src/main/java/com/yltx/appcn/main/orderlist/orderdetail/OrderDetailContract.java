package com.yltx.appcn.main.orderlist.orderdetail;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.OrderDetail;
import com.yltx.appcn.bean.ResultInfo;

import java.util.List;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/25.
 */

public class OrderDetailContract {
    interface IView extends BaseContract.IBaseView {
        String getOrderId();

        String getOrderStatus();

        String getUserId();

        String getUserName();

        String getRemark();

        List<String> getImgList();

        void onLoadOrderResult(OrderDetail result);

        void onDealOrderResult(ResultInfo result);

        void onUploadPicResult();

    }

    interface IModel extends BaseContract.IBaseModel {

        void loadOrder(Context context, String TAG, String orderId, IPresenter iPresenter);

        void dealOrder(Context context, String TAG, String id, String status, String personNo, String personName, String remark,IPresenter iPresenter);

        void uploadPic(Context context, String TAG, IPresenter iPresenter);
    }

    interface IPresenter extends BaseContract.IBasePresenter {

        void loadOrder(Context context, String TAG);

        void dealOrder(Context context, String TAG);

        void uploadPic(Context context, String TAG);

        void onLoadOrderResult(OrderDetail result);

        void onDealOrderResult(ResultInfo result);

        void onUploadPicResult();
    }
}
