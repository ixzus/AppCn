package com.yltx.appcn.main.orderlist.orderdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yltx.appcn.R;

import java.util.ArrayList;
import java.util.List;

public class GridImageAdapter extends RecyclerView.Adapter<GridImageAdapter.ViewHolder> {
    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_PICTURE = 2;
    private LayoutInflater mInflater;
    private List<String> list = new ArrayList<>();
    private int selectMax = 9;
    private Context context;
    private boolean isUpdate;

    protected OnAddClickListener mAddClickListener;

    public interface OnAddClickListener {
        void onAddClick();
    }

    public void setOnAddClickListener(OnAddClickListener mAddClickListener) {
        this.mAddClickListener = mAddClickListener;
    }

    protected OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public GridImageAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
        notifyDataSetChanged();
    }

    public void setSelectMax(int selectMax) {
        this.selectMax = selectMax;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        ImageView mDel;

        public ViewHolder(View view) {
            super(view);
            mImg = (ImageView) view.findViewById(R.id.imageView);
            mDel = (ImageView) view.findViewById(R.id.del);
        }
    }

    @Override
    public int getItemCount() {
        if (isUpdate) {
            if (list.size() < selectMax) {
                return list.size() + 1;
            } else {
                return list.size();
            }
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isUpdate) {
            if (isShowAddItem(position)) {
                return TYPE_CAMERA;
            } else {
                return TYPE_PICTURE;
            }
        } else {
            return TYPE_PICTURE;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.rv_orderdetail_pic,
                viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    private boolean isShowAddItem(int position) {
        int size = list.size() == 0 ? 0 : list.size();
        return position == size;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        if (getItemViewType(position) == TYPE_CAMERA) {
            Glide.with(context).load(R.mipmap.ic_add).crossFade().into(viewHolder.mImg);
            viewHolder.mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAddClickListener.onAddClick();
                }
            });
        } else {
            Glide.with(context).load(list.get(position)).crossFade().into(viewHolder.mImg);
            viewHolder.mDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = viewHolder.getAdapterPosition();
                    if (index != RecyclerView.NO_POSITION) {
                        list.remove(index);
                        notifyItemRemoved(index);
                        notifyItemRangeChanged(index, list.size());
                    }
                }
            });
            if (null != mItemClickListener) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = viewHolder.getAdapterPosition();
                        mItemClickListener.onItemClick(position, view);
                    }
                });
            }
        }
    }

}
