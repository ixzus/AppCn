package com.yltx.appcn.bean;

/**
 * 功能描述:
 * Created by ixzus on 2017/5/5.
 */

public class JPush {

    /**
     * type : ORDER_PAY_SUCCESS
     * code : 0
     * msg : 【车牌号】，【违章订单编号】违章已经办理成功>>
     */

    private String type;
    private String code;
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
