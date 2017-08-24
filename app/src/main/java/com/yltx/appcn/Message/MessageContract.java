package com.yltx.appcn.message;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.GetMessagesRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class MessageContract {
    interface IMessageView extends BaseContract.IBaseView {
        void onGetMessagesResult(GetMessagesRsBean.DataBean data);
    }
    interface IMessagePresenter extends BaseContract.IBasePresenter {
        void GetMessages(Context contex, String tag, String json);
        void  GetMessagesResult(GetMessagesRsBean.DataBean data);
    }
    interface IMessageModel extends BaseContract.IBaseModel {
        void doGetMessages(Context context, String tag, String postJson, IMessagePresenter mPresenter);//发送验证码
    }
}
