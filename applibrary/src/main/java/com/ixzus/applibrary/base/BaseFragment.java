package com.ixzus.applibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ixzus.applibrary.R;
import com.ixzus.applibrary.impl.ISwipeBack;
import com.jaeger.library.StatusBarUtil;
import com.jude.swipbackhelper.SwipeBackHelper;

import butterknife.ButterKnife;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/18.
 */

public abstract class BaseFragment<V extends BaseContract.IBaseView, P extends BasePresenter> extends LazyFragment implements BaseContract.IBaseView {
    protected P presenter;
    protected String TAG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (0 != initLayout()) {
            return inflater.inflate(initLayout(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TAG = getActivity().getPackageName() + "." + getClass().getSimpleName();
        presenter = initPresenter();
        if (null != presenter) {
            presenter.attatch(initModule(), this);
        }
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        StatusBarUtil.setTranslucent(getActivity());
        ButterKnife.bind(this, view);
        initView();
        initData();

        if (this instanceof ISwipeBack) {
            SwipeBackHelper.onCreate(getActivity());
        }
    }


    protected abstract P initPresenter();

    protected abstract BaseModel initModule();

    protected abstract
    @LayoutRes
    int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected void toolbar(String centerText, boolean isBack, String backText) {
        if (isBack) {
            getActivity().findViewById(R.id.toolbar_back).setVisibility(View.VISIBLE);
            getActivity().findViewById(R.id.toolbar_line).setVisibility(View.VISIBLE);
            if (getActivity().findViewById(R.id.toolbar_back) != null) {
                getActivity().findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().onBackPressed();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(backText)) {
            ((TextView) getActivity().findViewById(R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            ((TextView) getActivity().findViewById(R.id.toolbar_title)).setText(centerText);
        }

    }
}
