package com.example.applibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public abstract class BaseActivity<V extends BaseContract.IBaseView, P extends BasePresenter> extends AppCompatActivity implements BaseContract.IBaseView {
    protected P presenter;
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        if (null != presenter) {
            presenter.attatch(initModule(), this);
        }
        initView();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
        mImmersionBar.destroy();
    }

    protected abstract void initView();

    protected abstract BaseModel initModule();

    protected abstract P initPresenter();
}
