package com.yltx.appcn.message.messagedetail;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.ACache;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.GetMessagesRsBean;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.ResultInfoUtils;

import static com.yltx.appcn.utils.Consta.SP_PARAMS.USERID;

/**
 * Author：Wq
 * Date：2017/8/24 14:59
 * Description：//todo
 */

public class MessageDetailModel extends BaseModel implements MessageDetailContract.IMessageDetailModel{

    @Override
    public void doGetMessageDetail(Context context, String tag, String postJson, MessageDetailContract.IMessageDetailPresenter mPresenter) {



    }
}
