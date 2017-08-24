package com.yltx.appcn.main.orderlist;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by luoxw on 2016/8/10.
 */

public class Level1Item implements MultiItemEntity {
    public boolean isLast;
    public String orderId;
    public String status;
    public String orderNo;
    public String orderTime;
    public String point;
    public String fine;
    public String overduefine;
    public String addr;
    public String reson;

    public Level1Item(String orderId,String status,String orderNo, String orderTime, String point, String fine, String overduefine, String addr, String reson, boolean isLast) {
        this.orderId = orderId;
        this.status = status;
        this.orderNo = orderNo;
        this.orderTime = orderTime;
        this.point = point;
        this.fine = fine;
        this.overduefine = overduefine;
        this.addr = addr;
        this.reson = reson;
        this.isLast = isLast;
    }

    @Override
    public int getItemType() {
        return OrderListAdapter.TYPE_LEVEL_1;
    }


}