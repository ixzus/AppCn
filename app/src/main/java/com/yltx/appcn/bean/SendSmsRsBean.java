package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/23 11:50
 * Description：//todo
 */

public class SendSmsRsBean {
    /**
     * type : success
     * code : success
     * message : 发送成功,请注意查收!
     * value : null
     * success : true
     */

    private String type;
    private String code;
    private String message;
    private String value;
    private boolean success;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
