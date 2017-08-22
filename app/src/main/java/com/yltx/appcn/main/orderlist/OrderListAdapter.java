package com.yltx.appcn.main.orderlist;

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
    private String mSessionId;

    public OrderListAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.rv_order_list);
        addItemType(TYPE_LEVEL_1, R.layout.rv_order_list_item);
    }


    private int pos;
    private View clickView;

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.orderNum, lv0.title);
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
