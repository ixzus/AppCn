package com.yltx.appcn;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.login.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static android.support.v7.widget.RecyclerView.VERTICAL;

@Route(path = "/app/MainActivity")
public class MainActivity extends RxAppCompatActivity {

    private RefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private QuickAdapter quickAdapter;
    private View viewNoData;
    private View viewErr;
    private List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//
    }

    private void next() {
        ARouter.getInstance().build("/login/loginActivity").navigation(this, new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.e("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.e("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.e("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.e("ARouter", "被拦截了");
            }
        });
    }

    private void initView() {

        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        viewNoData = getLayoutInflater().inflate(R.layout.view_no_data, (ViewGroup) recyclerView.getParent(), false);
        viewErr = getLayoutInflater().inflate(R.layout.view_err, (ViewGroup) recyclerView.getParent(), false);
        viewNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                quickAdapter.setNewData(listData);
            }
        });
        viewErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                quickAdapter.setNewData(listData);
            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                quickAdapter.setNewData(null);
                quickAdapter.setEmptyView(viewNoData);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });

        refreshLayout.setEnableAutoLoadmore(true);
        for (int i = 0; i < 15; ++i) {
            listData.add("" + i);
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));

        quickAdapter = new QuickAdapter();
        quickAdapter.addHeaderView(viewErr);
        recyclerView.setAdapter(quickAdapter);
        quickAdapter.setEmptyView(viewNoData);
        quickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        quickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toasty.normal(MainActivity.this, "click " + position).show();
            }
        });

    }


}
