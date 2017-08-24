package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/24 11:24
 * Description：//todo
 */

public class GetCarDetailRsBean {
    /**
     * code : success
     * message : 查询成功!
     * data : {"id":"893","memberId":"4987000","carnumber":"粤BZ412U","carcode":"177730","cardrivenumber":"691490","provincePrefix":null,"carNumCode":null,"carType":"1","queryDate":null,"deleted":"1","dataSource":"chejiaoshou","userId":null,"privateFlag":"1","drivingPermit":null,"drivingPermit2":null,"totalScore":"0","totalAmount":"0.0","count":"0","code":null,"message":null,"carTypeName":null,"carCount":null}
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
         * id : 893
         * memberId : 4987000
         * carnumber : 粤BZ412U
         * carcode : 177730
         * cardrivenumber : 691490
         * provincePrefix : null
         * carNumCode : null
         * carType : 1
         * queryDate : null
         * deleted : 1
         * dataSource : chejiaoshou
         * userId : null
         * privateFlag : 1
         * drivingPermit : null
         * drivingPermit2 : null
         * totalScore : 0
         * totalAmount : 0.0
         * count : 0
         * code : null
         * message : null
         * carTypeName : null
         * carCount : null
         */

        private String id;
        private String memberId;
        private String carnumber;
        private String carcode;
        private String cardrivenumber;
        private Object provincePrefix;
        private Object carNumCode;
        private String carType;
        private Object queryDate;
        private String deleted;
        private String dataSource;
        private Object userId;
        private String privateFlag;
        private Object drivingPermit;
        private Object drivingPermit2;
        private String totalScore;
        private String totalAmount;
        private String count;
        private Object code;
        private Object message;
        private Object carTypeName;
        private Object carCount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getCarnumber() {
            return carnumber;
        }

        public void setCarnumber(String carnumber) {
            this.carnumber = carnumber;
        }

        public String getCarcode() {
            return carcode;
        }

        public void setCarcode(String carcode) {
            this.carcode = carcode;
        }

        public String getCardrivenumber() {
            return cardrivenumber;
        }

        public void setCardrivenumber(String cardrivenumber) {
            this.cardrivenumber = cardrivenumber;
        }

        public Object getProvincePrefix() {
            return provincePrefix;
        }

        public void setProvincePrefix(Object provincePrefix) {
            this.provincePrefix = provincePrefix;
        }

        public Object getCarNumCode() {
            return carNumCode;
        }

        public void setCarNumCode(Object carNumCode) {
            this.carNumCode = carNumCode;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public Object getQueryDate() {
            return queryDate;
        }

        public void setQueryDate(Object queryDate) {
            this.queryDate = queryDate;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getDataSource() {
            return dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getPrivateFlag() {
            return privateFlag;
        }

        public void setPrivateFlag(String privateFlag) {
            this.privateFlag = privateFlag;
        }

        public Object getDrivingPermit() {
            return drivingPermit;
        }

        public void setDrivingPermit(Object drivingPermit) {
            this.drivingPermit = drivingPermit;
        }

        public Object getDrivingPermit2() {
            return drivingPermit2;
        }

        public void setDrivingPermit2(Object drivingPermit2) {
            this.drivingPermit2 = drivingPermit2;
        }

        public String getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(String totalScore) {
            this.totalScore = totalScore;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
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

        public Object getCarTypeName() {
            return carTypeName;
        }

        public void setCarTypeName(Object carTypeName) {
            this.carTypeName = carTypeName;
        }

        public Object getCarCount() {
            return carCount;
        }

        public void setCarCount(Object carCount) {
            this.carCount = carCount;
        }
    }
}
