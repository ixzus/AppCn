package com.yltx.appcn.bean;

/**
 * Author：Kylin
 * Date：2017/4/19:15:57
 * Description：//todo
 */
public class LoginInfo {

    /**
     * accountName : 13100000000
     * cordova : 1.2.0
     * loginChannel : android
     * loginType : mobilePhone
     * model : generic-GoogleNexus5-5.0.0-API21-1080x1920
     * password : 1E85F8C31435545444S5DA9F27D1C3C
     * platform : android
     * reference : yigongshe
     * uuid : 00000000000000015919462266
     * version : 1.2.0
     */

    private String accountName;//*会员帐号
    private String cordova;//*APP版本号  手机型号
    private String loginChannel;//*登陆渠道  weixin    android            ios    terminal
    private String platform;// *平台  weixin    android            ios    terminal
    private String reference;//*来源 定制版盛世嘉：shengshijia,标准版：yigongshe
    private String loginType;//*登录类型  mobilePhone手机 email 邮件eeepay移付宝用户
    private String model;// 手机型号
    private String password;//*密码
    private String uuid;//* 手机硬件唯一标识
    private String version;// * 手机版本号
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCordova() {
        return cordova;
    }

    public void setCordova(String cordova) {
        this.cordova = cordova;
    }

    public String getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(String loginChannel) {
        this.loginChannel = loginChannel;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
