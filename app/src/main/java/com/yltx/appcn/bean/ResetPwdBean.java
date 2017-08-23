package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/23 14:49
 * Description：//todo
 */

public class ResetPwdBean {

    private String phone;

    private String code;

    private String newPassword;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
