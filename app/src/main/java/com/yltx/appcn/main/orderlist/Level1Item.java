package com.yltx.appcn.main.orderlist;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by luoxw on 2016/8/10.
 */

public class Level1Item implements MultiItemEntity {
    public String title;
    public boolean isLast;

    public Level1Item(String title,boolean isLast) {
        this.title = title;
        this.isLast = isLast;
    }

    @Override
    public int getItemType() {
        return OrderListAdapter.TYPE_LEVEL_1;
    }


}