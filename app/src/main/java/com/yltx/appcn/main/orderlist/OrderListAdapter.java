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
        addItemType(TYPE_LEVEL_0, R.layout.rv_order_list_item);
        addItemType(TYPE_LEVEL_1, R.layout.rv_order_list_item);
    }


    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.carNo, lv0.title);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });

                break;
            case TYPE_LEVEL_1:

                break;

        }
    }
}
