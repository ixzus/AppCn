package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/4/21 9:49
 * Description：//todo 个人信息返回的javaBean
 */

public class CartMemberBean {

    /**
     * code : success
     * member : {"accountName":"yigongshe15989473462","memberId":"5206","nickName":"鹅蛋","phone":"15989473462","photoUrl":"201608/2b53f345-ab0f-4cb1-923f-0f4f9cc75968.jpg"}
     * message : 操作成功
     */

    private String code;
    private MemberBean member;
    private String message;

    private String appTimeOut;
    private String wCode;

    public String getwCode() {
        return wCode;
    }

    public void setwCode(String wCode) {
        this.wCode = wCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppTimeOut() {
        return appTimeOut;
    }

    public void setAppTimeOut(String appTimeOut) {
        this.appTimeOut = appTimeOut;
    }

    public static class MemberBean {
        /**
         * accountName : yigongshe15989473462
         * memberId : 5206
         * nickName : 鹅蛋
         * phone : 15989473462
         * photoUrl : 201608/2b53f345-ab0f-4cb1-923f-0f4f9cc75968.jpg
         */

        private String accountName;
        private String memberId;
        private String nickName;
        private String phone;
        private String photoUrl;


        /*认证相关*/
        //是否实名
        private String nameAuthentication;
        //是否提交驾驶资料
        private String completeDrivingLicense;
        //商户号
        private String clientId;
        //机具
        private String machineSN;
        //商户手机号
        private String memberPhone;



        //是否支持互联网认证
        private String internetStatus;//N:一定要机具  Y：可要可不要  互联网认证
        //是否支持支付宝
        private String AlipayStatus;
        //是否支持微信
        private String weChatStatus;


        public String getNameAuthentication() {
            return nameAuthentication;
        }

        public void setNameAuthentication(String nameAuthentication) {
            this.nameAuthentication = nameAuthentication;
        }

        public String getCompleteDrivingLicense() {
            return completeDrivingLicense;
        }

        public void setCompleteDrivingLicense(String completeDrivingLicense) {
            this.completeDrivingLicense = completeDrivingLicense;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getMachineSN() {
            return machineSN;
        }

        public void setMachineSN(String machineSN) {
            this.machineSN = machineSN;
        }

        public String getMemberPhone() {
            return memberPhone;
        }

        public void setMemberPhone(String memberPhone) {
            this.memberPhone = memberPhone;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getAlipayStatus() {
            return AlipayStatus;
        }

        public void setAlipayStatus(String alipayStatus) {
            AlipayStatus = alipayStatus;
        }

        public String getWeChatStatus() {
            return weChatStatus;
        }

        public void setWeChatStatus(String weChatStatus) {
            this.weChatStatus = weChatStatus;
        }

        public String getInternetStatus() {
            return internetStatus;
        }

        public void setInternetStatus(String internetStatus) {
            this.internetStatus = internetStatus;
        }
    }
}
