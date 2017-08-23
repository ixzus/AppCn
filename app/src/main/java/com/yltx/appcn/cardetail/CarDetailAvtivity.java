package com.yltx.appcn.cardetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperTextView;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：Wq
 * Date：2017/8/22 10:54
 * Description：//todo
 */


@Route(path = "/cardetail/CarDetailAvtivity")

public class CarDetailAvtivity extends BaseActivity<CarDetailContract.ICarDetailView, CarDetailPresenter> implements CarDetailContract.ICarDetailView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_line)
    View toolbarLine;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.st_cartype)
    SuperTextView stCartype;
    @BindView(R.id.st_carnum)
    SuperTextView stCarnum;
    @BindView(R.id.st_enginnum)
    SuperTextView stEnginnum;
    @BindView(R.id.st_framenum)
    SuperTextView stFramenum;
    @BindView(R.id.st_carproperty)
    SuperTextView stCarproperty;
    @BindView(R.id.st_original)
    SuperTextView stOriginal;
    @BindView(R.id.iv_original)
    ImageView ivOriginal;
    @BindView(R.id.st_copy)
    SuperTextView stCopy;
    @BindView(R.id.iv_copy)
    ImageView ivCopy;

    @Override
    protected CarDetailPresenter initPresenter() {
        return new CarDetailPresenter();
    }

    @Override
    protected BaseModel initModule() {
        return new CarDetailModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_cardetail;
    }

    @Override
    protected void initView() {

        toolbar("车辆详情", true, null);

    }

    @Override
    protected void initData() {


        setData();

    }

    private void setData() {

//        @BindView(R.id.st_cartype)
//        SuperTextView stCartype;
//        @BindView(R.id.st_carnum)
//        SuperTextView stCarnum;
//        @BindView(R.id.st_enginnum)
//        SuperTextView stEnginnum;
//        @BindView(R.id.st_framenum)
//        SuperTextView stFramenum;
//        @BindView(R.id.st_carproperty)
//        SuperTextView stCarproperty;

        stCartype.setRightString("小型客车");
        stCarnum.setRightString("粤B888888");
        stEnginnum.setRightString("skk5865555");
        stFramenum.setRightString("755LKJHKJK");
        stCarproperty.setRightString("性质1");



    }

    @Override
    public void retry() {

    }

    @Override
    public void onGetCarDetailResult(String code) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
