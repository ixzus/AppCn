package com.yltx.appcn.main.orderlist;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.math.BigDecimal;

/**
 * Created by luoxw on 2016/8/10.
 */
public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    public boolean isCheck;
    public boolean isOnly;
    public String orderId;
    public String status;
    public String carNo;
    public String orderNo;
    public String orderTime;
    public String point;
    public String fine;
    public String overduefine;
    public String addr;
    public String reson;
    public String payCount;
    public String orderCount;

    public Level0Item(String orderId, String status, String carNo, String orderNo, String orderTime,
                      String point, String fine, String overduefine, String addr, String reson,
                      String orderCount, String payCount, boolean isOnly) {
        this.isOnly = isOnly;
        this.orderId = orderId;
        this.status = status;
        this.carNo = carNo;
        this.orderNo = orderNo;
        this.orderTime = orderTime;
        this.point = point;
        this.fine = fine;
        this.overduefine = overduefine;
        this.addr = addr;
        this.reson = reson;
        this.orderCount = orderCount;
        this.payCount = payCount;
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
