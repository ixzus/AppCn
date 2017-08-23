package com.yltx.appcn.main.orderlist;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by luoxw on 2016/8/10.
 */
public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    public String title;
    public boolean isCheck;

    public Level0Item(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return OrderListAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
