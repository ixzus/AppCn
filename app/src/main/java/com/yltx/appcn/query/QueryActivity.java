package com.yltx.appcn.query;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ixzus.applibrary.base.ActivityManager;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.util.ACache;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.ClearEditTextView;
import com.jakewharton.rxbinding2.view.RxView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.CarServiceOrderRsObj;

import org.w3c.dom.Text;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static com.yltx.appcn.utils.Consta.SP_PARAMS.USERID;

/**
 * Author：Wq
 * Date：2017/8/28 11:12
 * Description：//todo
 */

@Route(path = "/query/QueryActivity")
public class QueryActivity extends BaseActivity<QueryContract.IQueryView, QueryPersenter> implements QueryContract.IQueryView {

    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_query)
    RecyclerView rvQuery;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_forgot)
    TextView tvForgot;
    @BindView(R.id.cet_input)
    ClearEditTextView cetInput;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    private QueryAdapter adapter;
    private List<CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean> datas = new ArrayList<CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean>();

    private String carNum = "";
    private String carId = "";

    private int pageNo = 1;
    private int pageSize = 3;
    private int pageTotal;

    private boolean isRefresh;

    private View viewNoData;
    private View viewLoading;

    private CarServiceOrderRsObj.DataBean.DispatchListBean bean;

    @Override
    protected QueryPersenter initPresenter() {
        return new QueryPersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new QueryModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_query;
    }

    @Override
    protected void initView() {
        toolbar("查询订单", true, null);
        initEvent();
        initRv();
    }

    private void initEvent() {

        RxView.clicks(ivBack)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        finish();
                    }
                });

        RxView.clicks(tvForgot)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        if(isVirual()){
                            toLoadData();
                        }
                    }
                });




    }


    private void initRv() {

        viewNoData = this.getLayoutInflater().inflate(R.layout.view_no_data, (ViewGroup) rvQuery.getParent(), false);
        viewLoading = this.getLayoutInflater().inflate(R.layout.view_loading, (ViewGroup) rvQuery.getParent(), false);
        viewNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                pageNo = 1;
                datas.clear();
                presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
            }
        });

        rvQuery.setHasFixedSize(true);
        rvQuery.setItemAnimator(new DefaultItemAnimator());
        rvQuery.setLayoutManager(new LinearLayoutManager(QueryActivity.this));


        adapter = new QueryAdapter();
        adapter.setEmptyView(viewNoData);

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (pageNo * pageSize < pageTotal) {
                    pageNo++;
                    presenter.loadData(ActivityManager.getInstance().getCurrentActivity(), TAG);
                }
            }
        }, rvQuery);

        //设置item间距，30dp
        rvQuery.addItemDecoration(new SpaceItemDecoration(10));

        adapter.setNewData(datas);
        rvQuery.setLayoutManager(new LinearLayoutManager(this));
        rvQuery.setAdapter(adapter);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void retry() {

    }


    @Override
    public void onLoadDataResult(CarServiceOrderRsObj.DataBean dataBean) {
//        if (null != dataBean) {
//            //
//            bean = dataBean.getDispatchList().get(0);
//            carId = dataBean.getDispatchList().get(0).getCarId();
//            datas = dataBean.getDispatchList().get(0).getList();
//            adapter.setNewData(datas);
//
//
//
//
//        }

        adapter.setEmptyView(viewNoData);
        if (isRefresh) {
            refreshLayout.finishRefresh();
            isRefresh = false;
        }


        if (isRefresh) {
            refreshLayout.finishRefresh();
            isRefresh = false;
        }
        if (null == dataBean.getDispatchList() || 0 == dataBean.getDispatchList().size()) {
//            Toast.show("空数据");

            if (1 == pageNo) {
            } else {
                adapter.loadMoreFail();
                refreshLayout.setEnableRefresh(true);
            }
            return;
        }
        datas = dataBean.getDispatchList().get(0).getList();
        refreshLayout.setEnableRefresh(true);
        try {
            pageTotal = Integer.valueOf(dataBean.getTotalCount());
        } catch (NumberFormatException e) {
        }

        if (1 == pageNo) {
            adapter.setNewData(datas);
        } else {
            adapter.addData(datas);
        }
        if (pageNo * pageSize < pageTotal) {
            adapter.loadMoreComplete();
        } else {
            adapter.loadMoreEnd();
        }


    }

    @Override
    public String getInput() {
        return cetInput.getText().toString().trim();
    }

    @Override
    public String getUserId() {
        return ACache.get(QueryActivity.this).getAsString(USERID);
    }

    @Override
    public int getPageNo() {
        return 1;
    }

    @Override
    public int getPageSize() {
        return 10;
    }

    @Override
    public String getCarNum() {
        return URLEncoder.encode(getInput());
    }

    public void toLoadData() {
        if(isVirual()){
            presenter.loadData(QueryActivity.this, TAG);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public boolean isVirual(){
        if(TextUtils.isEmpty(getInput())){
            Toast.show("输入车牌号不能为空!");
            return false;
        }else if (getInput().length()<7||getInput().length()>9){
            Toast.show("输入车牌号错误!");

            return false;
        }
        return true;
    }


}
