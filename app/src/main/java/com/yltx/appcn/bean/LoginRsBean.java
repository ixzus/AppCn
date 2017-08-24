package com.yltx.appcn.bean;

import java.util.List;

/**
 * Author：Wq
 * Date：2017/8/23 10:38
 * Description：//todo
 */

public class LoginRsBean {
    /**
     * responseHeader : {"terminalType":null,"channel":null,"expire":null,"requestId":null,"sessionId":null,"sessionExpires":null,"token":null,"cookieMemberId":null,"success":null,"message":null,"errorCode":null,"errorMsg":null,"errors":[],"warnings":[]}
     * code : error
     * message : 手机号与密码不匹配
     * userId : null
     * username : null
     * realname : null
     * email : null
     * phone : null
     * tel : null
     * fax : null
     * entType : null
     * xsessionid : null
     * xsessionExpireDate : null
     * xsessionExpireTime : null
     * msn : null
     */

    private ResponseHeaderBean responseHeader;
    private String code;
    private String message;
    private String userId;
    private String username;
    private String realname;
    private String email;
    private String phone;
    private String tel;
    private String fax;
    private String entType;
    private String xsessionid;
    private String xsessionExpireDate;
    private String xsessionExpireTime;
    private String msn;

    public ResponseHeaderBean getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeaderBean responseHeader) {
        this.responseHeader = responseHeader;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType;
    }

    public String getXsessionid() {
        return xsessionid;
    }

    public void setXsessionid(String xsessionid) {
        this.xsessionid = xsessionid;
    }

    public String getXsessionExpireDate() {
        return xsessionExpireDate;
    }

    public void setXsessionExpireDate(String xsessionExpireDate) {
        this.xsessionExpireDate = xsessionExpireDate;
    }

    public String getXsessionExpireTime() {
        return xsessionExpireTime;
    }

    public void setXsessionExpireTime(String xsessionExpireTime) {
        this.xsessionExpireTime = xsessionExpireTime;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public static class ResponseHeaderBean {
        /**
         * terminalType : null
         * channel : null
         * expire : null
         * requestId : null
         * sessionId : null
         * sessionExpires : null
         * token : null
         * cookieMemberId : null
         * success : null
         * message : null
         * errorCode : null
         * errorMsg : null
         * errors : []
         * warnings : []
         */

        private String terminalType;
        private String channel;
        private String expire;
        private String requestId;
        private String sessionId;
        private String sessionExpires;
        private String token;
        private String cookieMemberId;
        private String success;
        private String message;
        private String errorCode;
        private String errorMsg;
        private List<?> errors;
        private List<?> warnings;

        public String getTerminalType() {
            return terminalType;
        }

        public void setTerminalType(String terminalType) {
            this.terminalType = terminalType;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getExpire() {
            return expire;
        }

        public void setExpire(String expire) {
            this.expire = expire;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionExpires() {
            return sessionExpires;
        }

        public void setSessionExpires(String sessionExpires) {
            this.sessionExpires = sessionExpires;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getCookieMemberId() {
            return cookieMemberId;
        }

        public void setCookieMemberId(String cookieMemberId) {
            this.cookieMemberId = cookieMemberId;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public List<?> getErrors() {
            return errors;
        }

        public void setErrors(List<?> errors) {
            this.errors = errors;
        }

        public List<?> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<?> warnings) {
            this.warnings = warnings;
        }
    }
}
