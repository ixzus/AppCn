package com.ixzus.applibrary.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ixzus.applibrary.R;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.gyf.barlibrary.ImmersionBar;
import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public abstract class BaseActivity<V extends BaseContract.IBaseView, P extends BasePresenter>
        extends AppCompatActivity
        implements BaseContract.IBaseView {
    protected P presenter;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        if (null != presenter) {
            presenter.attatch(initModule(), this);
        }

        setContentView(initLayout());
        initView();
        initData();
        
        if (this instanceof IToolbar) {
            initToolbar(this);
        }

        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onCreate(this);
        }

        mImmersionBar = ImmersionBar.with(this);
        if (null != mImmersionBar) {
            if (null != findViewById(R.id.toolbar)) {
                mImmersionBar.titleBar(findViewById(R.id.toolbar));
            }
            mImmersionBar.init();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onPostCreate(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onDestroy(this);
        }
        if (null != presenter) {
            presenter.detach();
        }
        if (null != mImmersionBar) {
            mImmersionBar.destroy();
        }
    }

    protected abstract P initPresenter();

    protected abstract BaseModel initModule();

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    private void initToolbar(final Activity activity) {
        if (findViewById(R.id.toolbar) != null) {
            if (activity instanceof AppCompatActivity) {
                setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setActionBar((android.widget.Toolbar) findViewById(R.id.toolbar));
                    getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }

//        if (activity.findViewById(R.id.toolbar_title) != null) {
//            ((TextView) activity.findViewById(R.id.toolbar_title)).setText(activity.getTitle());
//        }
        if (findViewById(R.id.toolbar_back) != null) {
            findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }

    }

    protected void toolbar(String centerText, boolean isBack, String backText) {
        if (isBack) {
            findViewById(R.id.toolbar_back).setVisibility(View.VISIBLE);
            findViewById(R.id.toolbar_line).setVisibility(View.VISIBLE);
        }
        ((TextView) findViewById(R.id.toolbar_back_text)).setText(String.valueOf(backText));
        ((TextView) findViewById(R.id.toolbar_title)).setText(String.valueOf(centerText));

    }
}
