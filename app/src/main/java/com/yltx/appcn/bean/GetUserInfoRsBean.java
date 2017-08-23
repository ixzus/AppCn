package com.yltx.appcn.bean;

import java.util.List;

/**
 * Author：Wq
 * Date：2017/8/23 16:23
 * Description：//todo
 */

public class GetUserInfoRsBean {
    /**
     * responseHeader : {"terminalType":null,"channel":null,"expire":null,"requestId":null,"sessionId":null,"sessionExpires":null,"token":null,"cookieMemberId":null,"success":null,"message":null,"errorCode":null,"errorMsg":null,"errors":[],"warnings":[]}
     * code : null
     * message : null
     * userId : 15800
     * username : 13823315295
     * realname : 何伟强
     * email : null
     * phone : 13823315295
     * tel : 13823315295
     * fax : null
     * entType : null
     * xsessionid : null
     * xsessionExpireDate : null
     * xsessionExpireTime : null
     * msn : null
     */

    private ResponseHeaderBean responseHeader;
    private Object code;
    private Object message;
    private String userId;
    private String username;
    private String realname;
    private Object email;
    private String phone;
    private String tel;
    private Object fax;
    private Object entType;
    private Object xsessionid;
    private Object xsessionExpireDate;
    private Object xsessionExpireTime;
    private Object msn;

    public ResponseHeaderBean getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeaderBean responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
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

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }

    public Object getEntType() {
        return entType;
    }

    public void setEntType(Object entType) {
        this.entType = entType;
    }

    public Object getXsessionid() {
        return xsessionid;
    }

    public void setXsessionid(Object xsessionid) {
        this.xsessionid = xsessionid;
    }

    public Object getXsessionExpireDate() {
        return xsessionExpireDate;
    }

    public void setXsessionExpireDate(Object xsessionExpireDate) {
        this.xsessionExpireDate = xsessionExpireDate;
    }

    public Object getXsessionExpireTime() {
        return xsessionExpireTime;
    }

    public void setXsessionExpireTime(Object xsessionExpireTime) {
        this.xsessionExpireTime = xsessionExpireTime;
    }

    public Object getMsn() {
        return msn;
    }

    public void setMsn(Object msn) {
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

        private Object terminalType;
        private Object channel;
        private Object expire;
        private Object requestId;
        private Object sessionId;
        private Object sessionExpires;
        private Object token;
        private Object cookieMemberId;
        private Object success;
        private Object message;
        private Object errorCode;
        private Object errorMsg;
        private List<?> errors;
        private List<?> warnings;

        public Object getTerminalType() {
            return terminalType;
        }

        public void setTerminalType(Object terminalType) {
            this.terminalType = terminalType;
        }

        public Object getChannel() {
            return channel;
        }

        public void setChannel(Object channel) {
            this.channel = channel;
        }

        public Object getExpire() {
            return expire;
        }

        public void setExpire(Object expire) {
            this.expire = expire;
        }

        public Object getRequestId() {
            return requestId;
        }

        public void setRequestId(Object requestId) {
            this.requestId = requestId;
        }

        public Object getSessionId() {
            return sessionId;
        }

        public void setSessionId(Object sessionId) {
            this.sessionId = sessionId;
        }

        public Object getSessionExpires() {
            return sessionExpires;
        }

        public void setSessionExpires(Object sessionExpires) {
            this.sessionExpires = sessionExpires;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public Object getCookieMemberId() {
            return cookieMemberId;
        }

        public void setCookieMemberId(Object cookieMemberId) {
            this.cookieMemberId = cookieMemberId;
        }

        public Object getSuccess() {
            return success;
        }

        public void setSuccess(Object success) {
            this.success = success;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        public Object getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Object errorCode) {
            this.errorCode = errorCode;
        }

        public Object getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(Object errorMsg) {
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
