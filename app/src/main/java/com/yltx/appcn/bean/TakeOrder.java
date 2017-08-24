package com.yltx.appcn.bean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/24.
 */

public class TakeOrder {
    String id;
    String status;
    String handlePersonNo;
    String handlePersonName;
    String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHandlePersonNo() {
        return handlePersonNo;
    }

    public void setHandlePersonNo(String handlePersonNo) {
        this.handlePersonNo = handlePersonNo;
    }

    public String getHandlePersonName() {
        return handlePersonName;
    }

    public void setHandlePersonName(String handlePersonName) {
        this.handlePersonName = handlePersonName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
