package com.yltx.appcn.main.my;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperTextView;
import com.ixzus.applibrary.base.BaseFragment;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.util.ACache;
import com.jakewharton.rxbinding2.view.RxView;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.GetUserInfoRsBean;
import com.yltx.appcn.login.LoginActivity;
import com.yltx.appcn.main.home.HomeFragment;
import com.yltx.appcn.utils.Consta;
import com.yltx.appcn.utils.ResultInfoUtils;
import com.yltx.appcn.utils.SystemTool;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Author：Wq
 * Date：2017/8/23 16:31
 * Description：//todo
 */

public class MyInfoFragment extends BaseFragment<MyContract.IMyView, MyPersenter> implements MyContract.IMyView {
    @BindView(R.id.civ_photo)
    ImageView civPhoto;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.st_message)
    SuperTextView stMessage;
    @BindView(R.id.st_question)
    SuperTextView stQuestion;
    @BindView(R.id.st_setting)
    SuperTextView stSetting;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    Unbinder unbinder;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public static MyInfoFragment newInstance(String param1, String param2) {
        MyInfoFragment fragment = new MyInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    protected MyPersenter initPresenter() {
        return new MyPersenter();
    }

    @Override
    protected BaseModel initModule() {
        return new MyModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {

        tvVersion.setText(getResources().getString(R.string.app_name) + "v" + SystemTool.getAppVersion(getContext()));


        RxView.clicks(stMessage)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toMessage();
                    }
                });

        RxView.clicks(stQuestion)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toQuestion();
                    }
                });

        RxView.clicks(stSetting)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        toSetting();
                    }
                });




    }

    private void toSetting() {
        ARouter.getInstance().build("/other/SettingActivity").navigation(getActivity());
    }

    private void toQuestion() {
        ARouter.getInstance().build("/other/MyIssueActivity").navigation(getActivity());
    }

    @Override
    protected void initData() {
        String userId=ACache.get(getActivity()).getAsString(Consta.SP_PARAMS.USERID);
        presenter.loadData(this.getContext(),TAG,userId);//拉取数据
    }

    @Override
    public void fetchData() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResult(GetUserInfoRsBean mGetUserInfoRsBean) {

        if(null!=mGetUserInfoRsBean){
            setData(mGetUserInfoRsBean);
        }

    }

    private void setData(GetUserInfoRsBean mGetUserInfoRsBean) {
        if(null!=mGetUserInfoRsBean&& ResultInfoUtils.isSuccess(mGetUserInfoRsBean.getCode())){
            if(null!=mGetUserInfoRsBean.getData()){
                tvName.setText(mGetUserInfoRsBean.getData().getRealname());
                tvPhone.setText(mGetUserInfoRsBean.getData().getPhone());
            }

        }

    }


    private void toMessage() {
        ARouter.getInstance().build("/message/MessageActivity").navigation(getActivity());
    }


}
