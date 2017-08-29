package com.yltx.appcn.query;

import android.content.Context;

import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.net.NetObserver;
import com.ixzus.applibrary.net.RxSchedulers;
import com.ixzus.applibrary.util.Toast;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.net.RxRetrofit;
import com.yltx.appcn.utils.ResultInfoUtils;

/**
 * Author：Wq
 * Date：2017/8/28 11:15
 * Description：//todo
 */

public class QueryModel extends BaseModel implements QueryContract.IQueryModel {


    @Override
    public void doLoadData(Context context, String tag, String memenber, int pagerNum, int pagerSize, String carNum, final QueryContract.IQueryPresenter mPresenter) {

        RxRetrofit.getInstance().getApiService().getDispatchListQuery(memenber, pagerNum, pagerSize,carNum)
                .compose(((RxAppCompatActivity) context).<CarServiceOrderRsObj>bindToLifecycle())
                .compose(RxSchedulers.<CarServiceOrderRsObj>io_main())
                .subscribe(new NetObserver<CarServiceOrderRsObj>(context, tag, 0, false) {

                    @Override
                    public void onSuccess(int whichRequest, CarServiceOrderRsObj result) {
                        if(null!=result&& ResultInfoUtils.isSuccess(result.getCode())){
                            mPresenter.loadDataResult(result.getData());
                        }
                        Toast.show(result.getMessage());


                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {
//                        mPresenter.loadErr();
                    }
                });


    }
}
