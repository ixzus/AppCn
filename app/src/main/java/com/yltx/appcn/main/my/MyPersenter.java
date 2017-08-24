package com.yltx.appcn.main.my;



import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.GetUserInfoRsBean;

/**
 * Author：Wq
 * Date：2017/8/23 16:32
 * Description：//todo
 */

public class MyPersenter extends BasePresenter<MyModel,MyInfoFragment> implements MyContract.IMyPresenter {

    @Override
    public void loadData(Context contex, String tag,String str) {
            model.doLoadData(contex,tag,str,this);
    }

    @Override
    public void loadResult(GetUserInfoRsBean mGetUserInfoRsBean) {
        view.onResult(mGetUserInfoRsBean);

    }
}
