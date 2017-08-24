package com.yltx.appcn.message;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.ACache;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.GetMessagesRsBean;
import com.yltx.appcn.bean.ResetPwdRsBean;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.ResultInfoUtils;

import static com.yltx.appcn.utils.Consta.SP_PARAMS.USERID;

/**
 * Author：Wq
 * Date：2017/8/21 17:07
 * Description：//todo
 */

public class MessageModel extends BaseModel implements MessageContract.IMessageModel {

    @Override
    public void doGetMessages(Context context, String tag, String postJson, final MessageContract.IMessagePresenter mPresenter) {

//        //@// TODO: 2017/8/21 接口返回
        RxRetrofit.getInstance().getApiService().getMessages(ACache.get(context).getAsString(USERID),postJson)
                .compose(((RxAppCompatActivity)context).<GetMessagesRsBean>bindToLifecycle())
                .compose(RxSchedulers.<GetMessagesRsBean>io_main())
                .subscribe(new NetObserver<GetMessagesRsBean>(context, tag, 0, true) {
                    @Override
                    public void onSuccess(int whichRequest, GetMessagesRsBean mGetMessagesRsBean) {
                        if(null!=mGetMessagesRsBean&& ResultInfoUtils.isSuccess(mGetMessagesRsBean.getCode())){
                            if(null!=mGetMessagesRsBean.getData()){
                                mPresenter.GetMessagesResult(mGetMessagesRsBean.getData());
                            }
                        }
                        Toast.show(mGetMessagesRsBean.getMessage());
                    }
                    @Override
                    public void onError(int whichRequest, Throwable e) {
                    }
                });
    }
}
