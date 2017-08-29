package com.yltx.appcn.main.orderlist;

import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ixzus.applibrary.util.Toast;
import com.yltx.appcn.R;

import java.util.List;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/11.
 */

public class OrderListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    private int pos;
    private String orderViewType;


    public OrderListAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.rv_order_list);
        addItemType(TYPE_LEVEL_1, R.layout.rv_order_list_item);
    }


    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setChecked(R.id.radio, lv0.isCheck);
                holder.setText(R.id.carNo, lv0.carNo);
                holder.setText(R.id.orderNum, lv0.orderNo);
                holder.setText(R.id.orderTime, lv0.orderTime);
                holder.setText(R.id.orderPoint, (TextUtils.isEmpty(lv0.point) ? 0 : lv0.point) + "分");
                holder.setText(R.id.orderFine, (TextUtils.isEmpty(lv0.fine) ? 0 : lv0.fine) + "元");
                holder.setText(R.id.orderOverdueFine, (TextUtils.isEmpty(lv0.overduefine) ? 0 : lv0.overduefine) + "元");
                holder.setText(R.id.orderAddr, lv0.addr);
                holder.setText(R.id.orderReson, lv0.reson);

                /*****************/
                switch (lv0.status) {
                    case "0702":
                        orderViewType = OrderViewType.WAIT;
                        holder.setVisible(R.id.radio, true);
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
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_1);
                        break;
                    case OrderViewType.DEAL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.REJECT:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.REFUSE:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.DEALOK:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.SUCCESS:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.FAIL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.DEALFAIL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                }
                holder.setText(R.id.orderStatus, orderViewType);
                /*****************/

                holder.addOnClickListener(R.id.radio);
                if (lv0.isExpanded()) {
                    holder.getView(R.id.llopen).setVisibility(View.GONE);
                } else {
                    holder.getView(R.id.llopen).setVisibility(View.VISIBLE);
                }
                if (lv0.isOnly) {
                    holder.getView(R.id.llopen).setVisibility(View.GONE);
                }
                holder.getView(R.id.llopen).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (lv0.isExpanded()) {
                            return;
                        } else {
                            collapse(pos);
                        }
                        pos = holder.getAdapterPosition();
                        expand(pos);
                    }
                });

                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.orderNum, lv1.orderNo);
                holder.setText(R.id.orderTime, lv1.orderTime);
                holder.setText(R.id.orderPoint, (TextUtils.isEmpty(lv1.point) ? 0 : lv1.point) + "分");
                holder.setText(R.id.orderFine, (TextUtils.isEmpty(lv1.fine) ? 0 : lv1.fine) + "元");
                holder.setText(R.id.orderOverdueFine, (TextUtils.isEmpty(lv1.overduefine) ? 0 : lv1.overduefine) + "元");
                holder.setText(R.id.orderAddr, lv1.addr);
                holder.setText(R.id.orderReson, lv1.reson);
                /*****************/
                switch (lv1.status) {
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
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_1);
                        break;
                    case OrderViewType.DEAL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.REJECT:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.REFUSE:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.DEALOK:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.SUCCESS:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_3);
                        break;
                    case OrderViewType.FAIL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                    case OrderViewType.DEALFAIL:
                        holder.setBackgroundRes(R.id.orderStatus, R.mipmap.ic_status_2);
                        break;
                }
                holder.setText(R.id.orderStatus, orderViewType);
                /*****************/
                if (lv1.isLast) {
                    holder.getView(R.id.llclose).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.llclose).setVisibility(View.GONE);
                }
                holder.getView(R.id.llclose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.show("boolean:" + lv1.isLast);
                        collapse(pos);
                    }
                });

        }
    }
}
