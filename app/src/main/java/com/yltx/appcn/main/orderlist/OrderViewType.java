package com.yltx.appcn.main.orderlist;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/23.
 */

public interface OrderViewType {
    String WAIT = "待接单";
    String DEAL = "待办理";
    String REJECT = "已驳回";
    String DEALOK = "办理成功";
    String DEALFAIL = "办理失败";
    //最终状态
    String REFUSE = "已拒单";
    String SUCCESS = "处理成功";
    String FAIL = "处理失败";
}
