package com.yltx.appcn.base;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public class BasePresenter<M extends BaseModule, V extends BaseContract.IBaseView> {
    public M module;
    public V view;

    void attatch(M m, V v) {
        this.module = m;
        this.view = v;
    }

    void detach() {
        this.module = null;
        this.view = null;
    }
}
