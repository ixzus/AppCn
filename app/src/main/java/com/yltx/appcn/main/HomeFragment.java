package com.yltx.appcn.main;


import android.os.Bundle;
import android.widget.TextView;

import com.ixzus.applibrary.base.BaseFragment;
import com.ixzus.applibrary.base.BaseModel;
import com.orhanobut.logger.Logger;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.Unbinder;


public class HomeFragment extends BaseFragment<HomeContract.IView, HomePersenter> implements HomeContract.IView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.hometext)
    TextView hometext;
    Unbinder unbinder;

    private String mParam1;
    private String mParam2;


    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void fetchData() {
        Logger.e("fetchData:");
    }


    @Override
    protected HomePersenter initPresenter() {
        return new HomePersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new HomeModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        hometext.setText("kkkkkkkkkkkkkkkkkk");
    }

    @Override
    protected void initData() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void onResult(String code) {

    }
}
