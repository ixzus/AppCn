package com.yltx.appcn.main.orderlist.orderdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.SuperButton;
import com.blankj.utilcode.util.KeyboardUtils;
import com.ixzus.applibrary.base.BaseActivity;
import com.ixzus.applibrary.base.BaseModel;
import com.ixzus.applibrary.util.Toast;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.BaseDialog;
import com.ixzus.applibrary.widget.ViewConvertListener;
import com.ixzus.applibrary.widget.ViewHolder;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.orhanobut.logger.Logger;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.OrderDetail;
import com.yltx.appcn.bean.PicBean;
import com.yltx.appcn.bean.ResultInfo;
import com.yltx.appcn.bean.UpLoadPic;
import com.yltx.appcn.main.orderlist.OrderViewType;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/order/OrderDetailActivity")
public class OrderDetailActivity extends BaseActivity<OrderDetailContract.IView, OrderDetailPresenter> implements OrderDetailContract.IView, TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.btnRefuse)
    SuperButton btnRefuse;
    @BindView(R.id.btnUpload)
    SuperButton btnUpload;
    @BindView(R.id.llTwoBtn)
    LinearLayout llTwoBtn;
    @BindView(R.id.update)
    SuperButton update;
    @BindView(R.id.recyclerViewPic)
    RecyclerView recyclerViewPic;
    @BindView(R.id.llreson)
    LinearLayout llreson;
    @BindView(R.id.resonTitle)
    TextView resonTitle;
    @BindView(R.id.llpic)
    LinearLayout llpic;
    @BindView(R.id.llpicreson)
    LinearLayout llpicreson;
    @BindView(R.id.orderStatus)
    TextView orderStatus;

    /****************************/
    @BindView(R.id.startLineR)
    View startLineR;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.dealLineL)
    View dealLineL;
    @BindView(R.id.dealIv)
    ImageView dealIv;
    @BindView(R.id.dealLineR)
    View dealLineR;
    @BindView(R.id.dealText)
    TextView dealText;
    @BindView(R.id.deal_time)
    TextView dealTime;
    @BindView(R.id.rlDeal)
    RelativeLayout rlDeal;
    @BindView(R.id.endIv)
    ImageView endIv;
    @BindView(R.id.endLineL)
    View endLineL;
    @BindView(R.id.endText)
    TextView endText;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.point)
    TextView point;
    @BindView(R.id.fine)
    TextView fine;
    @BindView(R.id.lateFees)
    TextView lateFees;
    @BindView(R.id.no)
    TextView no;
    @BindView(R.id.sendTime)
    TextView sendTime;
    @BindView(R.id.takeTime)
    TextView takeTime;
    @BindView(R.id.uid)
    TextView uid;
    @BindView(R.id.carno)
    TextView carno;
    @BindView(R.id.breakTime)
    TextView breakTime;
    @BindView(R.id.breakAddr)
    TextView breakAddr;
    @BindView(R.id.breakInfo)
    TextView breakInfo;
    /****************************/
    private boolean isBtnUpload;
    private String dealStatus;
    private String remark;
    private String orderId;

    private List<PicBean> listData = new ArrayList<>();//show
    private List<OrderDetail.DataBean.FilesBean> listFile = new ArrayList<>();//old
    private List<UpLoadPic> listUpLoadPic = new ArrayList<>();//upload
    private GridImageAdapter adapter;

    private String orderViewType = OrderViewType.SUCCESS;

    private CustomHelper customHelper;
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private ArrayList<TImage> images;

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected OrderDetailPresenter initPresenter() {
        return new OrderDetailPresenter();
    }

    @Override
    protected BaseModel initModule() {
        return new OrderDetailModel();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadOrder(this, TAG);
    }

    private void statusAll() {
        startLineR.setBackgroundResource(R.color.base_color);
        dealIv.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_checkbox_press));
        dealLineL.setBackgroundResource(R.color.base_color);
        dealLineR.setBackgroundResource(R.color.base_color);
        dealText.setTextColor(getResources().getColor(R.color.base_color));
        endLineL.setBackgroundResource(R.color.base_color);
        endIv.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_checkbox_press));
        endText.setTextColor(getResources().getColor(R.color.base_color));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    private void initRv() {
//        listData.add("http://img17.3lian.com/d/file/201702/21/b79143e1538188ec4030ba5c3b93f6ea.png");
        recyclerViewPic.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new GridImageAdapter(OrderDetailActivity.this);
        adapter.setList(listData);
        adapter.setSelectMax(4);
        adapter.setUpdate(false);
        recyclerViewPic.setAdapter(adapter);
        adapter.setOnAddClickListener(new GridImageAdapter.OnAddClickListener() {
            @Override
            public void onAddClick() {
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
                                customHelper.onClick(v, getTakePhoto(), 4 - listData.size());
                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.album, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                customHelper.onClick(v, getTakePhoto(), 4 - listData.size());
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

    @Override
    public String getUserId() {
        return "15900";
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public String getUserName() {
        return "Android";
    }

    @OnClick({R.id.update, R.id.btnRefuse, R.id.ok, R.id.cancel, R.id.btnUpload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update:
                update.setVisibility(View.GONE);
                if (adapter != null) {
                    adapter.setUpdate(true);
                }
                break;
            case R.id.btnRefuse:
                KeyboardUtils.showSoftInput(OrderDetailActivity.this);
                BaseDialog.init()
                        .setLayoutId(R.layout.orderdetail_input)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(final ViewHolder holder, final AbsDialog dialog) {
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
                                        dealStatus = "0704";
                                        remark = ((EditText) holder.getView(R.id.inputRemark)).getText().toString().trim();
                                        if (TextUtils.isEmpty(remark)) {
                                            Toast.show("请填写失败原因");
                                        } else {
                                            dialog.dismiss();
                                            KeyboardUtils.hideSoftInput(v);
                                            presenter.dealOrder(OrderDetailActivity.this, TAG);
                                        }
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
            case R.id.cancel:
                KeyboardUtils.showSoftInput(OrderDetailActivity.this);
                BaseDialog.init()
                        .setLayoutId(R.layout.orderdetail_input_2)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(final ViewHolder holder, final AbsDialog dialog) {
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
                                        dealStatus = "0705";
                                        remark = ((EditText) holder.getView(R.id.inputRemark)).getText().toString().trim();
                                        if (TextUtils.isEmpty(remark)) {
                                            Toast.show("请填写失败原因");
                                        } else {
                                            dialog.dismiss();
                                            KeyboardUtils.hideSoftInput(v);
                                            presenter.dealOrder(OrderDetailActivity.this, TAG);
                                        }
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
            case R.id.ok:
                isBtnUpload = true;
                llTwoBtn.setVisibility(View.GONE);
                btnUpload.setVisibility(View.VISIBLE);
                llpic.setVisibility(View.VISIBLE);
                initRv();
                if (adapter != null) {
                    adapter.setUpdate(true);
                }
                customHelper = CustomHelper.of();
                break;
            case R.id.btnUpload:
                if (0 == listData.size()) {
                    Toast.show("请选择凭证");
                } else {
                    // TODO: 2017/8/25 匹配凭证
                    fitPic();
                    ConfirmDialog.newInstance("上传凭证")
                            .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                                @Override
                                public void convertView(ViewHolder holder, AbsDialog dialog) {
                                    dialog.dismiss();
                                }
                            })
                            .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                                @Override
                                public void convertView(ViewHolder holder, AbsDialog dialog) {
                                    dialog.dismiss();
                                    dealStatus = "0706";
                                    presenter.dealOrder(OrderDetailActivity.this, TAG);
                                }
                            })
                            .setMargin(60)
                            .setOutCancel(false)
                            .show(getSupportFragmentManager());
                }
                break;
        }
    }

    private void fitPic() {
        //原有凭证
        for (int i = 0, l = listFile.size(); i < l; ++i) {
            UpLoadPic uploadPic = new UpLoadPic();
            uploadPic.setEntityId(listFile.get(i).getEntityId());
            uploadPic.setEntityType(listFile.get(i).getEntityType());
            uploadPic.setFileName(listFile.get(i).getFilename());
            uploadPic.setId(listFile.get(i).getId());
            uploadPic.setUploadType("" + 2);//删除
            listUpLoadPic.add(uploadPic);

        }
        //未删除的凭证
        for (int i = 0, l = listUpLoadPic.size(); i < l; ++i) {
            for (int j = listData.size(); j > 0; --j) {
                if (listUpLoadPic.get(i).getId().equals(listData.get(j).getId())) {
                    listUpLoadPic.remove(j);
                }
            }
        }
        //新加
        for (int i = 0; i < listData.size(); ++i) {
            if (!listData.get(i).getUrl().contains("http")) {
                UpLoadPic uploadPic = new UpLoadPic();
                uploadPic.setEntityId(orderId);
                uploadPic.setEntityType("SUCCESSCERT");
                uploadPic.setFileName(listData.get(i).getUrl());
                uploadPic.setUploadType("1");//新增
                listUpLoadPic.add(uploadPic);
            }
        }
        //排序
        for (int i = 0; i < listUpLoadPic.size(); ++i) {
            listUpLoadPic.get(i).setStatus("" + i);
        }

    }


    @Override
    public void takeSuccess(TResult result) {
        images = result.getImages();
        for (TImage image : images) {
            PicBean picBean = new PicBean();
            picBean.setUrl(image.getCompressPath());
            listData.add(picBean);
        }
        adapter.updateList(listData);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Toast.show("" + msg);
    }

    @Override
    public void takeCancel() {

    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    public String getOrderId() {
        return "";
    }

    @Override
    public String getOrderStatus() {
        return dealStatus;
    }

    @Override
    public List<String> getImgList() {
        return null;
    }

    @Override
    public void onLoadOrderResult(OrderDetail result) {
        refreshUI(result.getData());
    }

    @Override
    public void onDealOrderResult(ResultInfo result) {

    }

    @Override
    public void onUploadPicResult() {

    }

    @Override
    public void retry() {

    }

    private void refreshUI(OrderDetail.DataBean dataBean) {
        orderId = dataBean.getId();
        money.setText((TextUtils.isEmpty(dataBean.getTotalPayAmount()) ? 0 : dataBean.getTotalPayAmount()) + "元");
        point.setText((TextUtils.isEmpty(dataBean.getDegree()) ? 0 : dataBean.getDegree()) + "分");
        lateFees.setText((TextUtils.isEmpty(dataBean.getLatefine()) ? 0 : dataBean.getLatefine()) + "元");
        fine.setText((TextUtils.isEmpty(dataBean.getCount()) ? 0 : dataBean.getCount()) + "元");
        no.setText(dataBean.getDispatchNo());
        sendTime.setText(dataBean.getDispatchDate());
        //接单时间
//        takeTime.setText();
        uid.setText(dataBean.getCarCompanyNo());
        carno.setText(dataBean.getCarNum());
        //违章时间
//        breakTime.setText(dataBean.get);
        String addr = "";
        if (!TextUtils.isEmpty(dataBean.getLocation())) {
            addr += ("[" + dataBean.getLocationName() + "] ");
        }
        breakAddr.setText(addr + dataBean.getLocation());
        breakInfo.setText(dataBean.getReason());
        //不同
        // TODO: 2017/8/25
        if (0 != dataBean.getFiles().size()) {
            listFile = dataBean.getFiles();
            for (OrderDetail.DataBean.FilesBean filesBean : listFile) {
                PicBean picBean = new PicBean();
                picBean.setUrl(filesBean.getPath());
                picBean.setId(filesBean.getId());
                listData.add(picBean);
            }
        }
        refreshStatus(dataBean.getStatus());
    }

    private void refreshStatus(String status) {
        switch (status) {
            case "0702":
                orderViewType = OrderViewType.WAIT;
                break;
            case "0703":
                orderViewType = OrderViewType.DEAL;
                break;
            case "0704":
                orderViewType = OrderViewType.REFUSE;
                break;
            case "0705":
                orderViewType = OrderViewType.DEALFAIL;
                break;
            case "0706":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0707":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0708":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0709":
                orderViewType = OrderViewType.REJECT;
                break;
            case "0520":
                orderViewType = OrderViewType.SUCCESS;
            case "0530":
                orderViewType = OrderViewType.FAIL;
                break;
            default:
                return;
        }
        switch (orderViewType) {
            case OrderViewType.WAIT:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_1));
                btnRefuse.setVisibility(View.VISIBLE);
                break;
            case OrderViewType.DEAL:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_2));
                llTwoBtn.setVisibility(View.VISIBLE);
                startLineR.setBackgroundResource(R.color.base_color);
                dealIv.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_checkbox_press));
                dealLineL.setBackgroundResource(R.color.base_color);
                dealText.setTextColor(getResources().getColor(R.color.base_color));
                break;
            case OrderViewType.REJECT:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_2));
                llpicreson.setVisibility(View.VISIBLE);
                llpic.setVisibility(View.VISIBLE);
                update.setVisibility(View.VISIBLE);
                dealIv.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_checkbox_press));
                initRv();
                customHelper = CustomHelper.of();
                break;
            case OrderViewType.REFUSE:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_3));
                llreson.setVisibility(View.VISIBLE);
                rlDeal.setVisibility(View.GONE);
                startLineR.setBackgroundResource(R.color.base_color);
                endLineL.setBackgroundResource(R.color.base_color);
                endIv.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_checkbox_press));
                endText.setTextColor(getResources().getColor(R.color.base_color));
                resonTitle.setText("拒单原因");
                break;
            case OrderViewType.DEALOK:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_3));
                llpic.setVisibility(View.VISIBLE);
                statusAll();
                initRv();
                break;
            case OrderViewType.SUCCESS:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_3));
                llpicreson.setVisibility(View.VISIBLE);
                llpic.setVisibility(View.VISIBLE);
                statusAll();
                initRv();
                break;
            case OrderViewType.FAIL:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_2));
                llreson.setVisibility(View.VISIBLE);
                statusAll();
                resonTitle.setText("办理失败原因");
                break;
            case OrderViewType.DEALFAIL:
                orderStatus.setBackground(AppCompatResources.getDrawable(this, R.mipmap.ic_status_2));
                llreson.setVisibility(View.VISIBLE);
                statusAll();
                resonTitle.setText("办理失败原因");
                break;
        }
        orderStatus.setText(orderViewType);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (isBtnUpload) {
                isBtnUpload = false;
                llTwoBtn.setVisibility(View.VISIBLE);
                btnUpload.setVisibility(View.GONE);
                llpic.setVisibility(View.GONE);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
