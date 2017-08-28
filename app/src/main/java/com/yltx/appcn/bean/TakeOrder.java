package com.yltx.appcn.bean;

import java.util.List;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/24.
 */

public class TakeOrder {
    String ids;
    String status;
    String handlePersonNo;
    String handlePersonName;
    String remark;
    List<UpLoadPic> fileList;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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

    public List<UpLoadPic> getFileList() {
        return fileList;
    }

    public void setFileList(List<UpLoadPic> fileList) {
        this.fileList = fileList;
    }
}
