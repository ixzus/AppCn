package com.yltx.appcn.query;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.appcn.R;
import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.GetMessagesRsBean;
import com.yltx.appcn.main.orderlist.OrderViewType;

/**
 * Author：Wq
 * Date：2017/8/21 20:31
 * Description：//todo  消息列表中的apapter
 */

public class QueryAdapter extends BaseQuickAdapter<CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean, BaseViewHolder> {

    private String orderViewType;


    public QueryAdapter() {
        super(R.layout.item_queryorder);
    }

    @Override
    protected void convert(BaseViewHolder helper,CarServiceOrderRsObj.DataBean.DispatchListBean.ListBean item) {

        helper.setText(R.id.tv_order_num, "派单号　"+item.getDispatchNo());

        helper.setText(R.id.tv_time, "派单时间 "+item.getDispatchDate());
        helper.setText(R.id.tv_kf_value, item.getDegree()+"分");
        helper.setText(R.id.tv_fk_value, item.getCount()+"元");
        helper.setText(R.id.tv_znj_value, item.getLatefine()+"元");
        helper.setText(R.id.tv_detail, item.getLocation());

//        helper.setText(R.id.tv_order_status, "已完成");
        /*****************/
        switch (item.getStatus()) {
            case "0702":
                orderViewType = OrderViewType.WAIT;
                break;
            case "0703":
                orderViewType = OrderViewType.DEAL;
                break;
            case "0704":
                orderViewType = OrderViewType.REFUSE;
                break;
            case "0705":
                orderViewType = OrderViewType.DEALFAIL;
                break;
            case "0706":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0707":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0708":
                orderViewType = OrderViewType.DEALOK;
                break;
            case "0709":
                orderViewType = OrderViewType.REJECT;
                break;
            case "0520":
                orderViewType = OrderViewType.SUCCESS;
            case "0530":
                orderViewType = OrderViewType.FAIL;
                break;
            default:
                return;
        }
        switch (orderViewType) {
            case OrderViewType.WAIT:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_1);
                break;
            case OrderViewType.DEAL:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_2);
                break;
            case OrderViewType.REJECT:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_2);
                break;
            case OrderViewType.REFUSE:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_3);
                break;
            case OrderViewType.DEALOK:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_3);
                break;
            case OrderViewType.SUCCESS:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_3);
                break;
            case OrderViewType.FAIL:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_2);
                break;
            case OrderViewType.DEALFAIL:
                helper.setBackgroundRes(R.id.tv_order_status, R.mipmap.ic_status_2);
                break;
        }
        helper.setText(R.id.tv_order_status, orderViewType);
        /*****************/
        helper.setText(R.id.tv_time, "派单时间 "+item.getDispatchDate());
        helper.setText(R.id.tv_kf_value, item.getDegree()+"分");
        helper.setText(R.id.tv_fk_value, item.getCount()+"元");
        helper.setText(R.id.tv_znj_value, item.getLatefine()+"元");
        helper.setText(R.id.tv_detail, item.getLocation());



    }
}
