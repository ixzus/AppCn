package com.yltx.appcn.bean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/24.
 */

public class HandleNum {

    /**
     * code : success
     * message : 查询成功
     * data : {"toHandleNum":"0","unReadedNum":"0","toOrderNum":"0","toRejectNum":"0"}
     */

    private String code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * toHandleNum : 0
         * unReadedNum : 0
         * toOrderNum : 0
         * toRejectNum : 0
         */

        private String toHandleNum;
        private String unReadedNum;
        private String toOrderNum;
        private String toRejectNum;

        public String getToHandleNum() {
            return toHandleNum;
        }

        public void setToHandleNum(String toHandleNum) {
            this.toHandleNum = toHandleNum;
        }

        public String getUnReadedNum() {
            return unReadedNum;
        }

        public void setUnReadedNum(String unReadedNum) {
            this.unReadedNum = unReadedNum;
        }

        public String getToOrderNum() {
            return toOrderNum;
        }

        public void setToOrderNum(String toOrderNum) {
            this.toOrderNum = toOrderNum;
        }

        public String getToRejectNum() {
            return toRejectNum;
        }

        public void setToRejectNum(String toRejectNum) {
            this.toRejectNum = toRejectNum;
        }
    }
}
