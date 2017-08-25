package com.yltx.appcn.bean;

import java.util.List;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/25.
 */

public class OrderDetail {


    /**
     * code : success
     * message : 查询成功
     * data : {"id":"2","orderId":"2910196","orderNo":"4631910196","dispatchNo":"2","carNum":"川U0639U","carCompanyNo":"1","carCompanyName":"万达地产","totalPayAmount":"1","totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"3","status":"0530","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":null,"reason":"机动车违反禁止标线指示的","count":"100","latefine":"0","poundage":null,"remark":"订单拒单。原因：null","files":[{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:06:14","dateUpdated":"2015-11-25 17:06:14","id":"46641","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg","filetype":"jpeg","contentType":"img/png","filesize":"35140","path":"http://192.168.3.49:10000//201511/815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg","operator":null,"deleted":false},{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:07:42","dateUpdated":"2015-11-25 17:07:51","id":"46642","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"ea4f7879-3cd7-43f8-bfc4-d4cc5de2c309.png","filetype":"png","contentType":"img/png","filesize":"113438","path":"http://192.168.3.49:10000//201511/ea4f7879-3cd7-43f8-bfc4-d4cc5de2c309.png","operator":null,"deleted":false},{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:07:44","dateUpdated":"2015-11-25 17:07:51","id":"46643","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"57a1a321-78e1-4dbc-bc79-3dbdc1d0c7fb.png","filetype":"png","contentType":"img/png","filesize":"686374","path":"http://192.168.3.49:10000//201511/57a1a321-78e1-4dbc-bc79-3dbdc1d0c7fb.png","operator":null,"deleted":false}],"handleDate":"2017-08-25 14:40:02","orderDate":"2017-08-25 14:40:02","ids":null,"location":"清江中路与清江西路交叉路口","locationName":"四川成都"}
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
         * id : 2
         * orderId : 2910196
         * orderNo : 4631910196
         * dispatchNo : 2
         * carNum : 川U0639U
         * carCompanyNo : 1
         * carCompanyName : 万达地产
         * totalPayAmount : 1
         * totalGivePoints : null
         * serviceCharge : null
         * singleCharge : null
         * degreeCharge : null
         * degree : 3
         * status : 0530
         * handlePersonName : null
         * handlePersonNo : null
         * orderTime : null
         * createdDate : null
         * updatedDate : null
         * scalNo : null
         * scalName : null
         * dispatchDate : 2017-08-16 10:40:20
         * carId : null
         * orderTimeStart : null
         * orderTimeEnd : null
         * archive : null
         * time : null
         * reason : 机动车违反禁止标线指示的
         * count : 100
         * latefine : 0
         * poundage : null
         * remark : 订单拒单。原因：null
         * files : [{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:06:14","dateUpdated":"2015-11-25 17:06:14","id":"46641","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg","filetype":"jpeg","contentType":"img/png","filesize":"35140","path":"http://192.168.3.49:10000//201511/815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg","operator":null,"deleted":false},{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:07:42","dateUpdated":"2015-11-25 17:07:51","id":"46642","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"ea4f7879-3cd7-43f8-bfc4-d4cc5de2c309.png","filetype":"png","contentType":"img/png","filesize":"113438","path":"http://192.168.3.49:10000//201511/ea4f7879-3cd7-43f8-bfc4-d4cc5de2c309.png","operator":null,"deleted":false},{"createdBy":null,"updatedBy":null,"dateCreated":"2015-11-25 17:07:44","dateUpdated":"2015-11-25 17:07:51","id":"46643","entityId":"2","entityType":"SUCCESSCERT","source":null,"mainCategory":null,"subCategory":null,"description":null,"filename":"57a1a321-78e1-4dbc-bc79-3dbdc1d0c7fb.png","filetype":"png","contentType":"img/png","filesize":"686374","path":"http://192.168.3.49:10000//201511/57a1a321-78e1-4dbc-bc79-3dbdc1d0c7fb.png","operator":null,"deleted":false}]
         * handleDate : 2017-08-25 14:40:02
         * orderDate : 2017-08-25 14:40:02
         * ids : null
         * location : 清江中路与清江西路交叉路口
         * locationName : 四川成都
         */

        private String id;
        private String orderId;
        private String orderNo;
        private String dispatchNo;
        private String carNum;
        private String carCompanyNo;
        private String carCompanyName;
        private String totalPayAmount;
        private Object totalGivePoints;
        private Object serviceCharge;
        private Object singleCharge;
        private Object degreeCharge;
        private String degree;
        private String status;
        private Object handlePersonName;
        private Object handlePersonNo;
        private Object orderTime;
        private Object createdDate;
        private Object updatedDate;
        private Object scalNo;
        private Object scalName;
        private String dispatchDate;
        private Object carId;
        private Object orderTimeStart;
        private Object orderTimeEnd;
        private Object archive;
        private Object time;
        private String reason;
        private String count;
        private String latefine;
        private Object poundage;
        private String remark;
        private String handleDate;
        private String orderDate;
        private Object ids;
        private String location;
        private String locationName;
        private List<FilesBean> files;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getDispatchNo() {
            return dispatchNo;
        }

        public void setDispatchNo(String dispatchNo) {
            this.dispatchNo = dispatchNo;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getCarCompanyNo() {
            return carCompanyNo;
        }

        public void setCarCompanyNo(String carCompanyNo) {
            this.carCompanyNo = carCompanyNo;
        }

        public String getCarCompanyName() {
            return carCompanyName;
        }

        public void setCarCompanyName(String carCompanyName) {
            this.carCompanyName = carCompanyName;
        }

        public String getTotalPayAmount() {
            return totalPayAmount;
        }

        public void setTotalPayAmount(String totalPayAmount) {
            this.totalPayAmount = totalPayAmount;
        }

        public Object getTotalGivePoints() {
            return totalGivePoints;
        }

        public void setTotalGivePoints(Object totalGivePoints) {
            this.totalGivePoints = totalGivePoints;
        }

        public Object getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(Object serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        public Object getSingleCharge() {
            return singleCharge;
        }

        public void setSingleCharge(Object singleCharge) {
            this.singleCharge = singleCharge;
        }

        public Object getDegreeCharge() {
            return degreeCharge;
        }

        public void setDegreeCharge(Object degreeCharge) {
            this.degreeCharge = degreeCharge;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getHandlePersonName() {
            return handlePersonName;
        }

        public void setHandlePersonName(Object handlePersonName) {
            this.handlePersonName = handlePersonName;
        }

        public Object getHandlePersonNo() {
            return handlePersonNo;
        }

        public void setHandlePersonNo(Object handlePersonNo) {
            this.handlePersonNo = handlePersonNo;
        }

        public Object getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(Object orderTime) {
            this.orderTime = orderTime;
        }

        public Object getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Object createdDate) {
            this.createdDate = createdDate;
        }

        public Object getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(Object updatedDate) {
            this.updatedDate = updatedDate;
        }

        public Object getScalNo() {
            return scalNo;
        }

        public void setScalNo(Object scalNo) {
            this.scalNo = scalNo;
        }

        public Object getScalName() {
            return scalName;
        }

        public void setScalName(Object scalName) {
            this.scalName = scalName;
        }

        public String getDispatchDate() {
            return dispatchDate;
        }

        public void setDispatchDate(String dispatchDate) {
            this.dispatchDate = dispatchDate;
        }

        public Object getCarId() {
            return carId;
        }

        public void setCarId(Object carId) {
            this.carId = carId;
        }

        public Object getOrderTimeStart() {
            return orderTimeStart;
        }

        public void setOrderTimeStart(Object orderTimeStart) {
            this.orderTimeStart = orderTimeStart;
        }

        public Object getOrderTimeEnd() {
            return orderTimeEnd;
        }

        public void setOrderTimeEnd(Object orderTimeEnd) {
            this.orderTimeEnd = orderTimeEnd;
        }

        public Object getArchive() {
            return archive;
        }

        public void setArchive(Object archive) {
            this.archive = archive;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(Object time) {
            this.time = time;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getLatefine() {
            return latefine;
        }

        public void setLatefine(String latefine) {
            this.latefine = latefine;
        }

        public Object getPoundage() {
            return poundage;
        }

        public void setPoundage(Object poundage) {
            this.poundage = poundage;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getHandleDate() {
            return handleDate;
        }

        public void setHandleDate(String handleDate) {
            this.handleDate = handleDate;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public Object getIds() {
            return ids;
        }

        public void setIds(Object ids) {
            this.ids = ids;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public List<FilesBean> getFiles() {
            return files;
        }

        public void setFiles(List<FilesBean> files) {
            this.files = files;
        }

        public static class FilesBean {
            /**
             * createdBy : null
             * updatedBy : null
             * dateCreated : 2015-11-25 17:06:14
             * dateUpdated : 2015-11-25 17:06:14
             * id : 46641
             * entityId : 2
             * entityType : SUCCESSCERT
             * source : null
             * mainCategory : null
             * subCategory : null
             * description : null
             * filename : 815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg
             * filetype : jpeg
             * contentType : img/png
             * filesize : 35140
             * path : http://192.168.3.49:10000//201511/815a9f33-7013-4e29-ad75-d4b1794e5b72.jpeg
             * operator : null
             * deleted : false
             */

            private Object createdBy;
            private Object updatedBy;
            private String dateCreated;
            private String dateUpdated;
            private String id;
            private String entityId;
            private String entityType;
            private Object source;
            private Object mainCategory;
            private Object subCategory;
            private Object description;
            private String filename;
            private String filetype;
            private String contentType;
            private String filesize;
            private String path;
            private Object operator;
            private boolean deleted;

            public Object getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(Object createdBy) {
                this.createdBy = createdBy;
            }

            public Object getUpdatedBy() {
                return updatedBy;
            }

            public void setUpdatedBy(Object updatedBy) {
                this.updatedBy = updatedBy;
            }

            public String getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(String dateCreated) {
                this.dateCreated = dateCreated;
            }

            public String getDateUpdated() {
                return dateUpdated;
            }

            public void setDateUpdated(String dateUpdated) {
                this.dateUpdated = dateUpdated;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public String getEntityType() {
                return entityType;
            }

            public void setEntityType(String entityType) {
                this.entityType = entityType;
            }

            public Object getSource() {
                return source;
            }

            public void setSource(Object source) {
                this.source = source;
            }

            public Object getMainCategory() {
                return mainCategory;
            }

            public void setMainCategory(Object mainCategory) {
                this.mainCategory = mainCategory;
            }

            public Object getSubCategory() {
                return subCategory;
            }

            public void setSubCategory(Object subCategory) {
                this.subCategory = subCategory;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public String getFiletype() {
                return filetype;
            }

            public void setFiletype(String filetype) {
                this.filetype = filetype;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getFilesize() {
                return filesize;
            }

            public void setFilesize(String filesize) {
                this.filesize = filesize;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public Object getOperator() {
                return operator;
            }

            public void setOperator(Object operator) {
                this.operator = operator;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }
    }
}
