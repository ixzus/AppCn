package com.yltx.appcn.main.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.bumptech.glide.Glide;
import com.ixzus.applibrary.base.BaseFragment;
import com.ixzus.applibrary.base.BaseModel;
import com.orhanobut.logger.Logger;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.HandleNum;
import com.yltx.appcn.main.orderlist.OrderListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;


public class HomeFragment extends BaseFragment<HomeContract.IView, HomePersenter> implements HomeContract.IView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.banner)
    BGABanner banner;
    @BindView(R.id.msg)
    ImageView msg;
    @BindView(R.id.newmsg)
    TextView newmsg;
    @BindView(R.id.wait)
    TextView wait;
    @BindView(R.id.deal)
    TextView deal;
    @BindView(R.id.reject)
    TextView reject;
    @BindView(R.id.refuse)
    TextView refuse;
    @BindView(R.id.finish)
    TextView finish;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.btnDeal)
    SuperButton btnDeal;

    private String mParam1;
    private String mParam2;

    private int orderType;

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
        initBanner();
    }

    @Override
    protected void initData() {

    }

    @Override
    public String getUserId() {
        return null;
    }


    @Override
    public void onResult(HandleNum result) {

    }

    private List<String> imgList = new ArrayList<>();

    private void initBanner() {
        imgList.clear();
        imgList.add("");
        imgList.add("");
        banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                if (getActivity() != null) {
                    if (0 == position) {
                        Glide.with(getActivity())
                                .load(R.mipmap.banner)
                                .placeholder(R.mipmap.banner)
                                .dontAnimate()
                                .into(itemView);
                    }
                    if (1 == position) {
                        Glide.with(getActivity())
                                .load(R.mipmap.banner)
                                .placeholder(R.mipmap.banner)
                                .dontAnimate()
                                .into(itemView);
                    }
                }
            }
        });
        banner.setData(imgList, null);
        banner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
//                ToastUtils.showCustomMessage("click" + position);
                if (0 == position) {
                    //http://mp.weixin.qq.com/s/kxm9MKp2IFuSbJp6uVMxGw
//                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
//                    intent.putExtra("mURL", "http://mp.weixin.qq.com/s/uISldavNThcR08Cah_teWg");
//                    intent.putExtra("mTITLE", "订单为何处理失败? 看过来！");
//                    startActivity(intent);
                }
            }
        });
    }

    @OnClick({R.id.wait, R.id.deal, R.id.reject, R.id.refuse, R.id.finish, R.id.btnDeal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wait:
                orderType = 0;
                break;
            case R.id.deal:
                orderType = 1;
                break;
            case R.id.reject:
                orderType = 2;
                break;
            case R.id.refuse:
                orderType = 3;
                break;
            case R.id.finish:
                orderType = 4;
                break;
            case R.id.btnDeal:
                orderType = 5;
                break;
        }
        Intent intent = new Intent(getActivity(), OrderListActivity.class);
        intent.putExtra("orderType", orderType);
        startActivity(intent);
    }
}
