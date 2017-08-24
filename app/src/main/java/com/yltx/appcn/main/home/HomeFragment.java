package com.yltx.appcn.main.home;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperButton;
import com.bumptech.glide.Glide;
import com.ixzus.applibrary.base.ActivityManager;
import com.ixzus.applibrary.base.BaseFragment;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.util.ACache;
import com.ixzus.applibrary.util.Toast;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.HandleNum;
import com.yltx.appcn.utils.Consta;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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
    @BindView(R.id.btnDeal)
    SuperButton btnDeal;
    @BindView(R.id.waitTip)
    TextView waitTip;
    @BindView(R.id.dealTip)
    TextView dealTip;
    @BindView(R.id.rejectTip)
    TextView rejectTip;
    @BindView(R.id.totalNum)
    TextView totalNum;
    @BindView(R.id.waitNum)
    TextView waitNum;
    @BindView(R.id.dealNum)
    TextView dealNum;
    @BindView(R.id.rejectNum)
    TextView rejectNum;

    private String mParam1;
    private String mParam2;

    private List<String> imgList = new ArrayList<>();
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
        Toast.show("first");
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
    public void onResume() {
        super.onResume();
        presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
    }

    @Override
    public void refreshUI(HandleNum.DataBean bean) {
        waitNum.setText(bean.getToOrderNum());
        dealNum.setText(bean.getToHandleNum());
        rejectNum.setText(bean.getToRejectNum());
        int num1 = 0, num2 = 0, num3 = 0;
        try {
            num1 = Integer.valueOf(bean.getToOrderNum().toString());
            if (num1 > 0) {
                waitTip.setVisibility(View.VISIBLE);
                waitTip.setText(bean.getToOrderNum());
            }
        } catch (NumberFormatException e) {
        }
        try {
            num2 = Integer.valueOf(bean.getToHandleNum().toString());
            if (num2 > 0) {
                dealTip.setVisibility(View.VISIBLE);
                dealTip.setText(bean.getToHandleNum());
            }
        } catch (NumberFormatException e) {
        }
        try {
            num3 = Integer.valueOf(bean.getToRejectNum().toString());
            if (num3 > 0) {
                rejectTip.setVisibility(View.VISIBLE);
                rejectTip.setText(bean.getToRejectNum());
            }
        } catch (NumberFormatException e) {
        }

        totalNum.setText(String.valueOf(num1 + num2 + num3));
        try {
            if (Integer.valueOf(bean.getUnReadedNum().toString()) > 0) {
                newmsg.setVisibility(View.VISIBLE);
            }
        } catch (NumberFormatException e) {
        }
    }

    @Override
    public void initBanner() {
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
            }
        });
    }

    @Override
    public String getUserId() {
        return ACache.get(ActivityManager.getInstance().getCurrentActivity()).getAsString(Consta.SP_PARAMS.USERID);
    }


    @Override
    public void onResult(HandleNum.DataBean result) {
        refreshUI(result);
    }

    @OnClick({R.id.msg, R.id.wait, R.id.deal, R.id.reject, R.id.refuse, R.id.finish, R.id.btnDeal})
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
                orderType = 0;
                break;
            case R.id.msg:
                ARouter.getInstance().build("/message/MessageActivity").navigation(ActivityManager.getInstance().getCurrentActivity());
                return;
        }
        ARouter.getInstance().build("/order/OrderListActivity").withInt("orderType", orderType).navigation(ActivityManager.getInstance().getCurrentActivity());
    }

}
