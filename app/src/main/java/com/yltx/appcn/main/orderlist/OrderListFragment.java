package com.yltx.appcn.main.orderlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yltx.appcn.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


public class OrderListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    @BindView(R.id.rlBottom)
    RelativeLayout rlBottomLayout;

    private String mParam1;
    private String mParam2;

    private View viewNoData;
    private OrderListAdapter mAdapter;

    private List<MultiItemEntity> listData = new ArrayList<>();
    private int pageNo = 1;
    private int pageSize = 1;
    private int pageTotal;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if ("WAIT".equals(mParam1)) {
            rlBottomLayout.setVisibility(View.VISIBLE);
        } else {
            rlBottomLayout.setVisibility(View.GONE);
        }
    }


    private void initView() {
        viewNoData = getActivity().getLayoutInflater().inflate(R.layout.view_no_data, (ViewGroup) recyclerView.getParent(), false);
        viewNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageNo = 1;
                listData.clear();
                loadData(mParam1, pageNo, pageSize);
                mAdapter.setNewData(listData);
                mAdapter.loadMoreComplete();
            }
        });

//        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNo = 1;
                listData.clear();
                loadData(mParam1, pageNo, pageSize);
                mAdapter.setNewData(listData);
                mAdapter.loadMoreEnd();
                refreshlayout.finishRefresh(2000);
                //                mAdapter.setNewData(null);
                //                mAdapter.setEmptyView(viewNoData);
            }
        });


        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));

        mAdapter = new OrderListAdapter(null);
        mAdapter.setEmptyView(viewNoData);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        mAdapter.setLoadMoreView(new CustomLoadMoreView());
//        mAdapter.isFirstOnly(false);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toasty.normal(getActivity(), "click " + position).show();
            }
        });

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pageNo++;
                loadData(mParam1, pageNo, pageSize);
                mAdapter.addData(listData);
                if (pageNo > 1) {
                    mAdapter.loadMoreEnd();
                } else {
                    mAdapter.loadMoreComplete();
                }
            }
        }, recyclerView);

        recyclerView.setAdapter(mAdapter);

    }

    private void loadData(String orderType, int pageNo, int pageSize) {
        for (int i = 0; i < pageSize; ++i) {
            Level0Item lv0 = new Level0Item(orderType + pageNo);
            lv0.addSubItem(lv0);
            listData.add(lv0);
        }
    }
}
