package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/23 17:48
 * Description：//todo
 */

public class ModifyPwdBean
{

    private String userId;
    private String oldPassword;
    private String newPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
