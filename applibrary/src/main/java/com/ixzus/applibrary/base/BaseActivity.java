package com.ixzus.applibrary.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.ixzus.applibrary.R;
import com.ixzus.applibrary.constant.ViewStatus;
import com.ixzus.applibrary.impl.IReTry;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.net.RxManager;
import com.jaeger.library.StatusBarUtil;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public abstract class BaseActivity<V extends BaseContract.IBaseView, P extends BasePresenter>
        extends RxAppCompatActivity
        implements BaseContract.IBaseView, IReTry {
    protected P presenter;
//    private ImmersionBar mImmersionBar;
    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getPackageName() + "." + getClass().getSimpleName();
        presenter = initPresenter();
        if (null != presenter) {
            presenter.attatch(initModule(), this);
        }
        setContentView(initLayout());
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        StatusBarUtil.setTranslucent(this);
        ButterKnife.bind(this);
        initView();
        initData();

        if (this instanceof IToolbar) {
            initToolbar(this);
        }

        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onCreate(this);
        }

//        mImmersionBar = ImmersionBar.with(this);
//        if (null != mImmersionBar) {
////            if (null != findViewById(R.id.toolbar)) {
////                mImmersionBar.titleBar(findViewById(R.id.toolbar));
////            }
//            mImmersionBar.fitsSystemWindows(true);  //使用该属性,必须指定状态栏颜色
//            mImmersionBar.statusBarColor(R.color.white);
//            mImmersionBar.init();
//        }
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
        RxManager.getInstance().clear(TAG);
        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onDestroy(this);
        }
        if (null != presenter) {
            presenter.detach();
        }
//        if (null != mImmersionBar) {
//            mImmersionBar.destroy();
//        }
    }

    protected abstract P initPresenter();

    protected abstract BaseModel initModule();

    protected abstract
    @LayoutRes
    int initLayout();

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
        if (!TextUtils.isEmpty(backText)) {
            ((TextView) findViewById(R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            ((TextView) findViewById(R.id.toolbar_title)).setText(centerText);
        }

    }

    protected void toolbar(String centerText, boolean isBack, String backText, @ColorRes int bgColor, @ColorRes int tvColor) {
        if (0 != bgColor) {
            findViewById(R.id.toolbar).setBackgroundColor(ContextCompat.getColor(this, bgColor));
        }
        if (isBack) {
            findViewById(R.id.toolbar_back).setVisibility(View.VISIBLE);
            findViewById(R.id.toolbar_line).setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(backText)) {
            if (0 != tvColor) {
                ((TextView) findViewById(R.id.toolbar_back_text)).setTextColor(ContextCompat.getColor(this, tvColor));
            }
            ((TextView) findViewById(R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            if (0 != tvColor) {
                ((TextView) findViewById(R.id.toolbar_title)).setTextColor(ContextCompat.getColor(this, tvColor));
            }
            ((TextView) findViewById(R.id.toolbar_title)).setText(centerText);
        }

    }

    protected void showStatus(final int status) {
        hideStatus();
        switch (status) {
            case ViewStatus.STATUS:
//                hideStatus();
                break;
            case ViewStatus.STATUS_ERR:
                if (findViewById(R.id.viewErr) != null) {
                    findViewById(R.id.viewErr).setVisibility(View.VISIBLE);
                }

                break;
            case ViewStatus.STATUS_LOADING:
                if (findViewById(R.id.viewLoading) != null) {
                    findViewById(R.id.viewLoading).setVisibility(View.VISIBLE);
                }
                break;
            case ViewStatus.STATUS_NO_DATA:
                if (findViewById(R.id.viewNoData) != null) {
                    findViewById(R.id.viewNoData).setVisibility(View.VISIBLE);
                }
                break;
            case ViewStatus.STATUS_NO_NET:
                if (findViewById(R.id.viewNoNet) != null) {
                    findViewById(R.id.viewNoNet).setVisibility(View.VISIBLE);
                }
                break;
            default:
                break;
        }
    }

    private void hideStatus() {
        if (findViewById(R.id.viewErr) != null) {
            findViewById(R.id.viewErr).setVisibility(View.GONE);
            findViewById(R.id.viewErr).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    retry();
                }
            });
        }
        if (findViewById(R.id.viewLoading) != null) {
            findViewById(R.id.viewLoading).setVisibility(View.GONE);
            findViewById(R.id.viewLoading).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    retry();
                }
            });
        }
        if (findViewById(R.id.viewNoData) != null) {
            findViewById(R.id.viewNoData).setVisibility(View.GONE);
            findViewById(R.id.viewNoData).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    retry();
                }
            });
        }
        if (findViewById(R.id.viewNoNet) != null) {
            findViewById(R.id.viewNoNet).setVisibility(View.GONE);
            findViewById(R.id.viewNoNet).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    retry();
                }
            });
        }
    }
}
