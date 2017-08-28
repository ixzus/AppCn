package com.yltx.appcn.main.orderlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ixzus.applibrary.base.ActivityManager;
import com.ixzus.applibrary.base.BaseFragment;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.ViewHolder;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxAdapter;
import com.jakewharton.rxbinding2.widget.RxAdapterView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.ResultInfo;
import com.yltx.appcn.main.orderlist.orderdetail.OrderDetailActivity;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.rx_cache2.ActionsList;

import static com.yltx.appcn.main.orderlist.OrderListAdapter.TYPE_LEVEL_0;


public class OrderListFragment extends BaseFragment<OrderListContract.IView, OrderListPersenter> implements OrderListContract.IView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rlBottom)
    RelativeLayout rlBottomLayout;
    @BindView(R.id.radioAll)
    RadioButton radioAll;
    @BindView(R.id.carCount)
    TextView carCount;
    @BindView(R.id.carBreakCount)
    TextView carBreakCount;
    @BindView(R.id.moneyTotal)
    TextView moneyTotal;
    @BindView(R.id.btnTakeOrder)
    SuperButton btnTakeOrder;

    private String mParam1;
    private String mParam2;

    private View viewNoData;
    private View viewLoading;
    private OrderListAdapter mAdapter;

    private boolean isCheck = false;

    private List<MultiItemEntity> listData = new ArrayList<>();
    private int pageNo = 1;
    private int pageSize = 3;
    private int pageTotal;
    private String orderStatus;
    private boolean isRefresh;

    int count = 0;
    int breakCount = 0;
    double total = 0.0;


    public OrderListFragment() {
    }

    public static OrderListFragment newInstance(String param1, String param2) {
        OrderListFragment fragment = new OrderListFragment();
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
        reLoadData();
//        refreshLayout.autoRefresh(200);


    }

    @Override
    protected OrderListPersenter initPresenter() {
        return new OrderListPersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new OrderListModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_order_list;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666 && resultCode == 666) {
            reLoadData();
        }
    }

    private void reLoadData() {
        mAdapter.setEmptyView(viewLoading);
        refreshLayout.setEnableRefresh(false);
        isRefresh = true;
        pageNo = 1;
        listData.clear();
        presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
    }

    @Override
    public void initView() {
        load();
    }

    public void load() {
        switch (mParam1) {
            case OrderViewType.WAIT:
                orderStatus = "0702";
                break;
            case OrderViewType.DEAL:
                orderStatus = "0703";
                break;
            case OrderViewType.REJECT:
                orderStatus = "0709";
                break;
            case OrderViewType.REFUSE:
                orderStatus = "0704";
                break;
            case OrderViewType.SUCCESS:
                orderStatus = "9999";
                break;
        }
        if (OrderViewType.WAIT.equals(mParam1)) {
            rlBottomLayout.setVisibility(View.VISIBLE);
        } else {
            rlBottomLayout.setVisibility(View.GONE);
        }

        viewNoData = getActivity().getLayoutInflater().inflate(R.layout.view_no_data, (ViewGroup) recyclerView.getParent(), false);
        viewLoading = getActivity().getLayoutInflater().inflate(R.layout.view_loading, (ViewGroup) recyclerView.getParent(), false);
        viewNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        RxView.clicks(viewNoData)
                .throttleFirst(3, TimeUnit.SECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        isRefresh = true;
                        refreshLayout.setEnableRefresh(false);
                        mAdapter.setEmptyView(viewLoading);
                        pageNo = 1;
                        listData.clear();
                        presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
                    }
                });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                pageNo = 1;
                listData.clear();
                presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new OrderListAdapter(null);
        mAdapter.setEmptyView(viewNoData);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        mAdapter.setLoadMoreView(new CustomLoadMoreView());
//        mAdapter.isFirstOnly(false);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String orderId;
                if (TYPE_LEVEL_0 == adapter.getItemViewType(position)) {
                    orderId = ((Level0Item) adapter.getData().get(position)).orderId;
                } else {
                    orderId = ((Level1Item) adapter.getData().get(position)).orderId;
                }
                Toast.show("click");
//                ARouter.getInstance().build("/order/OrderDetailActivity").withString("orderId", orderId).navigation(ActivityManager.getInstance().getCurrentActivity(), 666);
                Intent intent = new Intent(ActivityManager.getInstance().getCurrentActivity(), OrderDetailActivity.class);
                intent.putExtra("orderId", orderId);
                startActivityForResult(intent, 666);
            }
        });

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (pageNo * pageSize < pageTotal) {
                    pageNo++;
                    presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
                }
            }
        }, recyclerView);

        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.radio) {
                    if (((Level0Item) adapter.getItem(position)).isCheck) {
                        ((Level0Item) adapter.getItem(position)).isCheck = false;
                        isCheck = false;
                        radioAll.setChecked(isCheck);
                    } else {
                        ((Level0Item) adapter.getItem(position)).isCheck = true;
                    }
                    adapter.notifyDataSetChanged();
                    itemSelect();
                }
            }
        });

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.radioAll, R.id.btnTakeOrder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioAll:
                isCheck = !isCheck;
                radioAll.setChecked(isCheck);
                doSelect();
                break;
            case R.id.btnTakeOrder:
                if (count < 1) {
                    Toast.show("请选择车辆");
                    return;
                }
                ArrayList<String> listInfo = new ArrayList<>();
                listInfo.add("" + count);
                listInfo.add("" + breakCount);
                listInfo.add("" + total);
                ConfirmDialog.newInstance("确认订单", listInfo)
                        .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                            @Override
                            public void convertView(ViewHolder holder, AbsDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                            @Override
                            public void convertView(ViewHolder holder, AbsDialog dialog) {
                                presenter.takeOrder(ActivityManager.getInstance().getCurrentActivity(), TAG);
                                dialog.dismiss();
                            }
                        })
                        .setMargin(60)
                        .setOutCancel(false)
                        .show(getActivity().getSupportFragmentManager());
                break;
        }
    }


    @Override
    public String getUserId() {
//        return ACache.get(ActivityManager.getInstance().getCurrentActivity()).getAsString(Consta.SP_PARAMS.USERID);
        return "15900";
    }

    @Override
    public String getUserName() {
//        return ACache.get(ActivityManager.getInstance().getCurrentActivity()).getAsString(Consta.SP_PARAMS.USERNAME);
        return "Android";
    }

    @Override
    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void onResult(CarServiceOrderRsObj result) {
        mAdapter.setEmptyView(viewNoData);
        if (isRefresh) {
            refreshLayout.finishRefresh();
            isRefresh = false;
        }
        if (null == result || null == result.getData() || null == result.getData().getDispatchList() || 0 == result.getData().getDispatchList().size()) {
//            Toast.show("空数据");
            if (1 == pageNo) {
                mAdapter.setNewData(null);
            } else {
                mAdapter.loadMoreFail();
                refreshLayout.setEnableRefresh(true);
            }
            return;
        }
        refreshLayout.setEnableRefresh(true);
        try {
            pageTotal = Integer.valueOf(result.getData().getTotalCount());
        } catch (NumberFormatException e) {
        }
        String addr;
        String addrstr;
        for (int i = 0; i < result.getData().getDispatchList().size(); ++i) {
            CarServiceOrderRsObj.DataBean.DispatchListBean dispatchListBean = result.getData().getDispatchList().get(i);
            List<CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean> list = dispatchListBean.getList();
            CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean listBean = list.get(0);
            addr = "";
            if (!TextUtils.isEmpty(listBean.getLocation())) {
                addr += ("[" + listBean.getLocation() + "]");
            }
            Level0Item lv0 = new Level0Item(listBean.getId(), listBean.getStatus(), listBean.getCarNum(),
                    listBean.getDispatchNo(), listBean.getDispatchDate(), listBean.getDegree(),
                    listBean.getCount(), listBean.getLatefine(),
                    addr + listBean.getLocationName(), listBean.getReason(),
                    dispatchListBean.getOrderCount(), dispatchListBean.getPayCount(), 1 == list.size());
            for (int j = 0; j < list.size(); ++j) {
                if (0 == j) {
                    continue;
                }
                Level1Item lv1;
                addrstr = "";
                if (!TextUtils.isEmpty(list.get(j).getLocation())) {
                    addrstr += ("[" + list.get(j).getLocation() + "]");
                }
                if (j == list.size() - 1) {
                    lv1 = new Level1Item(list.get(j).getId(), list.get(j).getStatus(), list.get(j).getDispatchNo(), list.get(j).getDispatchDate(),
                            list.get(j).getDegree(), list.get(j).getCount(), list.get(j).getLatefine(),
                            addrstr + list.get(j).getLocationName(), list.get(j).getReason(), true);
                } else {
                    lv1 = new Level1Item(list.get(j).getId(), list.get(j).getStatus(), list.get(j).getDispatchNo(), list.get(j).getDispatchDate(),
                            list.get(j).getDegree(), list.get(j).getCount(), list.get(j).getLatefine(),
                            addrstr + list.get(j).getLocationName(), list.get(j).getReason(), false);
                }
                lv0.addSubItem(lv1);
            }
            listData.add(lv0);
        }
        if (1 == pageNo) {
            mAdapter.setNewData(listData);
        } else {
            mAdapter.addData(listData);
        }
        if (pageNo * pageSize < pageTotal) {
            mAdapter.loadMoreComplete();
        } else {
            mAdapter.loadMoreEnd();
        }
        itemSelect();

    }

    @Override
    public void onResultErr() {
        if (isRefresh) {
            mAdapter.setEmptyView(viewNoData);
            refreshLayout.finishRefresh();
            isRefresh = false;
        }
    }

    @Override
    public String getIds() {
        List<String> listIds = new ArrayList<>();
        for (MultiItemEntity multiItemEntity : mAdapter.getData()) {
            if (TYPE_LEVEL_0 == multiItemEntity.getItemType()) {
                Level0Item lv0 = (Level0Item) multiItemEntity;
                if (lv0.isCheck) {
                    listIds.add(lv0.orderId);
                }
            }
        }
        return listToString(listIds);
    }

    public String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    @Override
    public void onTakeOrderResult(ResultInfo resultInfo) {
        reLoadData();
    }

    private void doSelect() {
        count = 0;
        breakCount = 0;
        total = 0.0;

        if (isCheck) {
            for (MultiItemEntity multiItemEntity : mAdapter.getData()) {
                if (TYPE_LEVEL_0 == multiItemEntity.getItemType()) {
                    Level0Item lv0 = (Level0Item) multiItemEntity;
                    lv0.isCheck = true;
                    ++count;
                    try {
                        breakCount += Integer.valueOf(lv0.orderCount);
                    } catch (NumberFormatException e) {
                    }
                    try {
                        total += Double.valueOf(lv0.payCount);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } else {
            for (MultiItemEntity multiItemEntity : mAdapter.getData()) {
                if (TYPE_LEVEL_0 == multiItemEntity.getItemType()) {
                    Level0Item lv0 = (Level0Item) multiItemEntity;
                    lv0.isCheck = false;
                    count = 0;
                    breakCount = 0;
                    total = 0.0;
                }
            }
        }
        mAdapter.notifyDataSetChanged();
        carCount.setText("" + count);
        carBreakCount.setText("" + breakCount);
        moneyTotal.setText("" + total);
    }

    private void itemSelect() {
        count = 0;
        breakCount = 0;
        total = 0.0;
        for (MultiItemEntity multiItemEntity : mAdapter.getData()) {
            if (TYPE_LEVEL_0 == multiItemEntity.getItemType()) {
                Level0Item lv0 = (Level0Item) multiItemEntity;
                if (lv0.isCheck) {
                    ++count;
                    try {
                        breakCount += Integer.valueOf(lv0.orderCount);
                    } catch (NumberFormatException e) {
                    }
                    try {
                        total += Double.valueOf(lv0.payCount);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        if (listData.size() == count) {
            isCheck = true;
            radioAll.setChecked(isCheck);
        }
        carCount.setText("" + count);
        carBreakCount.setText("" + breakCount);
        moneyTotal.setText("" + total);
    }
}
