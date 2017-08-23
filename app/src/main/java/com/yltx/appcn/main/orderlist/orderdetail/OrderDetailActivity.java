package com.yltx.appcn.main.orderlist.orderdetail;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.blankj.utilcode.util.KeyboardUtils;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.BaseDialog;
import com.ixzus.applibrary.widget.ViewConvertListener;
import com.ixzus.applibrary.widget.ViewHolder;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/order/OrderDetailActivity")
public class OrderDetailActivity extends RxAppCompatActivity {

    @BindView(R.id.oneBtn)
    SuperButton oneBtn;
    @BindView(R.id.update)
    SuperButton update;
    @BindView(R.id.recyclerViewPic)
    RecyclerView recyclerViewPic;

    private List<String> listData = new ArrayList<>();
    private PicAdapter mAdapter;
    private GridImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initRv();
    }

    private void initRv() {
//        listData.add("http://img17.3lian.com/d/file/201702/21/b79143e1538188ec4030ba5c3b93f6ea.png");
//        listData.add("http://img17.3lian.com/d/file/201702/21/b79143e1538188ec4030ba5c3b93f6ea.png");
        recyclerViewPic.setLayoutManager(new GridLayoutManager(this, 4));
//        mAdapter = new PicAdapter();
//        mAdapter.openLoadAnimation();
//        recyclerViewPic.setAdapter(mAdapter);
//        mAdapter.setNewData(listData);

        adapter = new GridImageAdapter(OrderDetailActivity.this);
        adapter.setList(listData);
        adapter.setSelectMax(4);
        adapter.setUpdate(false);
        recyclerViewPic.setAdapter(adapter);
        adapter.setOnAddClickListener(new GridImageAdapter.OnAddClickListener() {
            @Override
            public void onAddClick() {
                Logger.e("add");
                addDialog();
            }
        });
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Logger.e("item");
            }
        });

    }

    private void addDialog() {
        BaseDialog.init()
                .setLayoutId(R.layout.dialog_pic_from)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final AbsDialog dialog) {
                        holder.setOnClickListener(R.id.photo, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.show("拍照");
                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.album, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .setDimAmount(0.3f)
                .setAnimStyle(R.style.DialogBottomAnimation)
                .show(getSupportFragmentManager());
    }


    @OnClick({R.id.update, R.id.oneBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update:
                if (adapter != null) {
                    adapter.setUpdate(true);
                }

                break;
            case R.id.oneBtn:
                KeyboardUtils.showSoftInput(OrderDetailActivity.this);
                BaseDialog.init()
                        .setLayoutId(R.layout.orderdetail_input)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final AbsDialog dialog) {
                                holder.setOnClickListener(R.id.inputCancel, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        KeyboardUtils.hideSoftInput(v);
                                        dialog.dismiss();
                                    }
                                });
                                holder.setOnClickListener(R.id.inputCommnit, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        KeyboardUtils.hideSoftInput(v);
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setShowBottom(true)
                        .setDimAmount(0.3f)
                        .setOutCancel(false)
                        .setAnimStyle(R.style.DialogBottomAnimation)
                        .show(getSupportFragmentManager());
                break;
        }
    }
}
