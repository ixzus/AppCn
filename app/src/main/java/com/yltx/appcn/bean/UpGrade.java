package com.yltx.appcn.bean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/28.
 */

public class UpGrade {

    /**
     * code : success
     * message : 成功！
     * bean : {"devicetype":"Android","devicename":"Android","versionname":"1.0.3","versioncode":"4","upgradesize":"66666","upgradeurl":"http://oss.ygs001.com/mobai-0505-1.apk ","isforceupgrade":"N","description":"我要升级。。。。","appUrl":"http://oss.ygs001.com/mobai-0505-1.apk "}
     */

    private String code;
    private String message;
    private BeanBean bean;

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

    public BeanBean getBean() {
        return bean;
    }

    public void setBean(BeanBean bean) {
        this.bean = bean;
    }

    public static class BeanBean {
        /**
         * devicetype : Android
         * devicename : Android
         * versionname : 1.0.3
         * versioncode : 4
         * upgradesize : 66666
         * upgradeurl : http://oss.ygs001.com/mobai-0505-1.apk
         * isforceupgrade : N
         * description : 我要升级。。。。
         * appUrl : http://oss.ygs001.com/mobai-0505-1.apk
         */

        private String devicetype;
        private String devicename;
        private String versionname;
        private String versioncode;
        private String upgradesize;
        private String upgradeurl;
        private String isforceupgrade;
        private String description;
        private String appUrl;

        public String getDevicetype() {
            return devicetype;
        }

        public void setDevicetype(String devicetype) {
            this.devicetype = devicetype;
        }

        public String getDevicename() {
            return devicename;
        }

        public void setDevicename(String devicename) {
            this.devicename = devicename;
        }

        public String getVersionname() {
            return versionname;
        }

        public void setVersionname(String versionname) {
            this.versionname = versionname;
        }

        public String getVersioncode() {
            return versioncode;
        }

        public void setVersioncode(String versioncode) {
            this.versioncode = versioncode;
        }

        public String getUpgradesize() {
            return upgradesize;
        }

        public void setUpgradesize(String upgradesize) {
            this.upgradesize = upgradesize;
        }

        public String getUpgradeurl() {
            return upgradeurl;
        }

        public void setUpgradeurl(String upgradeurl) {
            this.upgradeurl = upgradeurl;
        }

        public String getIsforceupgrade() {
            return isforceupgrade;
        }

        public void setIsforceupgrade(String isforceupgrade) {
            this.isforceupgrade = isforceupgrade;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAppUrl() {
            return appUrl;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }
    }
}
