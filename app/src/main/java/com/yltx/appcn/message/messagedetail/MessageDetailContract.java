package com.yltx.appcn.message.messagedetail;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class MessageDetailContract {
    interface IMessageDetailView extends BaseContract.IBaseView {
        void onGetMessageDetailResult(GetMessagesRsBean.DataBean data);
    }
    interface IMessageDetailPresenter extends BaseContract.IBasePresenter {
        void GetMessageDetail(Context contex, String tag, String json);
        void  GetMessageDetailResult(GetMessagesRsBean.DataBean data);
    }
    interface IMessageDetailModel extends BaseContract.IBaseModel {
        void doGetMessageDetail(Context context, String tag, String postJson, IMessageDetailPresenter mPresenter);//发送验证码
    }
}
