package com.yltx.appcn.main.orderlist.orderdetail;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.appcn.R;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/11.
 */

public class PicAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PicAdapter() {
        super(R.layout.rv_orderdetail_pic);
    }

    @Override
    public int getItemCount() {
        if (mData.size() < 4) {
            return mData.size() + 1;
        } else {
            return mData.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return 0;
        } else {
            return 1;
        }
    }

    private boolean isShowAddItem(int position) {
        int size = mData.size() == 0 ? 0 : mData.size();
        return position == size;
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, String item) {
        if (0 == viewHolder.getItemViewType()) {
            viewHolder.setVisible(R.id.del, false);
            Glide.with(mContext).load(R.mipmap.ic_add).crossFade().into((ImageView) viewHolder.getView(R.id.imageView));
            viewHolder.addOnClickListener(R.id.imageView);
        } else {
            Glide.with(mContext).load(item).crossFade().into((ImageView) viewHolder.getView(R.id.imageView));
            viewHolder.addOnClickListener(R.id.del);
            viewHolder.addOnClickListener(R.id.imageView);
        }
    }
}
