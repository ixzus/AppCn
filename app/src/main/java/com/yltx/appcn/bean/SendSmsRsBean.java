package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/23 11:50
 * Description：//todo
 */

public class SendSmsRsBean {
    /**
     * code : success
     * message : 发送成功,请注意查收!
     * data : null
     */

    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}