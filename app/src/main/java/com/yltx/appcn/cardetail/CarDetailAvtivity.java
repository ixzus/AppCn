package com.yltx.appcn.cardetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.impl.IToolbar;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.CarType;
import com.yltx.appcn.bean.GetCarDetailRsBean;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yltx.appcn.utils.Consta.INTENT_KEY_PARAMS.CARID;
import static com.yltx.appcn.utils.Consta.sendSmsData.PHONE;

/**
 * Author：Wq
 * Date：2017/8/22 10:54
 * Description：//todo
 */


@Route(path = "/cardetail/CarDetailAvtivity")

public class CarDetailAvtivity extends BaseActivity<CarDetailContract.ICarDetailView, CarDetailPresenter> implements CarDetailContract.ICarDetailView, IToolbar {
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
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

    private String mCarId;

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
//        mCarId=getIntent().getStringExtra(CARID);

        mCarId="893";

        toolbar("车辆详情", true, null);


    }

    @Override
    protected void initData() {
        setData();
        presenter.GetCarDetail(CarDetailAvtivity.this,TAG,mCarId);


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
    public void onGetCarDetailResult(GetCarDetailRsBean.DataBean data) {

        setData(data);

    }

    private void setData(GetCarDetailRsBean.DataBean data) {
        //stCartype.setRightString(data.getCarType());
        stCartype.setRightString(CarType.getName(data.getCarType()));
        stCarnum.setRightString(data.getCarnumber());
        stEnginnum.setRightString(data.getCardrivenumber());
        stFramenum.setRightString(data.getCarcode());
        if("1".equals(data.getPrivateFlag())){
            stCarproperty.setRightString("单位车");
        }else if("0".equals(data.getPrivateFlag())){
            stCarproperty.setRightString("私家车");
        }
        Glide.with(this).load(data.getDrivingPermit()).placeholder(R.mipmap.cardetail_iv_normal).into(ivOriginal);
        Glide.with(this).load(data.getDrivingPermit2()).placeholder(R.mipmap.cardetail_iv_normal).into(ivCopy);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
