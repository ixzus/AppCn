package com.yltx.appcn.main.orderlist;

import android.support.v4.util.ArrayMap;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
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
    private ArrayMap array = new ArrayMap();

    private String orderViewType = OrderViewType.SUCCESS;

    public void setItemCheck(String key, boolean isCheck) {
        array.put(key, isCheck);
        notifyDataSetChanged();
    }

    public boolean isItemCheck(String key) {
        if (array.get(key) == null) {
            return false;
        }
        return Boolean.valueOf(array.get(key).toString());
    }

    public void allCheck(boolean isCheck) {
        for (int i = 0, l = mData.size(); i < l; ++i) {
            array.put(((Level0Item) mData.get(i)).title, isCheck);
        }
        notifyDataSetChanged();
    }

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
                holder.setText(R.id.orderNum, lv0.title);

                /*****************/
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
                holder.setText(R.id.orderNum, lv1.title);
                if (lv1.isLast) {
                    holder.getView(R.id.llclose).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.llclose).setVisibility(View.GONE);
                }
                holder.getView(R.id.llclose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        collapse(pos);
                    }
                });
                break;

        }
    }
}
