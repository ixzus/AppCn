package com.yltx.appcn.bean;

import java.util.List;

public class CarServiceOrderRsObj {


    /**
     * code : success
     * message : 加载成功！
     * data : {"code":null,"message":null,"dispatchList":[{"code":null,"message":null,"list":[{"id":"10","orderId":null,"orderNo":null,"dispatchNo":"10","carNum":"粤AX025K","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"粤AX025K","carId":"885","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null},{"code":null,"message":null,"list":[{"id":"11","orderId":null,"orderNo":null,"dispatchNo":"11","carNum":"川AM91G6","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"川AM91G6","carId":"886","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null},{"code":null,"message":null,"list":[{"id":"9","orderId":null,"orderNo":null,"dispatchNo":"9","carNum":"苏C956F0","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"苏C956F0","carId":"889","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null}],"totalCount":"6","totalPage":null}
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
         * code : null
         * message : null
         * dispatchList : [{"code":null,"message":null,"list":[{"id":"10","orderId":null,"orderNo":null,"dispatchNo":"10","carNum":"粤AX025K","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"粤AX025K","carId":"885","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null},{"code":null,"message":null,"list":[{"id":"11","orderId":null,"orderNo":null,"dispatchNo":"11","carNum":"川AM91G6","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"川AM91G6","carId":"886","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null},{"code":null,"message":null,"list":[{"id":"9","orderId":null,"orderNo":null,"dispatchNo":"9","carNum":"苏C956F0","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}],"carList":null,"carOrder":null,"carNumber":"苏C956F0","carId":"889","orderCount":"1","payCount":"0","totalCount":"6","totalPage":null}]
         * totalCount : 6
         * totalPage : null
         */

        private Object code;
        private Object message;
        private String totalCount;
        private Object totalPage;
        private List<DispatchListBean> dispatchList;

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

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public Object getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Object totalPage) {
            this.totalPage = totalPage;
        }

        public List<DispatchListBean> getDispatchList() {
            return dispatchList;
        }

        public void setDispatchList(List<DispatchListBean> dispatchList) {
            this.dispatchList = dispatchList;
        }

        public static class DispatchListBean {
            /**
             * code : null
             * message : null
             * list : [{"id":"10","orderId":null,"orderNo":null,"dispatchNo":"10","carNum":"粤AX025K","carCompanyNo":null,"carCompanyName":null,"totalPayAmount":null,"totalGivePoints":null,"serviceCharge":null,"singleCharge":null,"degreeCharge":null,"degree":"","status":"0702","handlePersonName":null,"handlePersonNo":null,"orderTime":null,"createdDate":null,"updatedDate":null,"scalNo":null,"scalName":null,"dispatchDate":"2017-08-16 10:40:20","carId":null,"orderTimeStart":null,"orderTimeEnd":null,"archive":null,"time":"","reason":"","count":"","latefine":"","poundage":null,"remark":null,"files":null,"handleDate":null,"orderDate":null,"location":"","locationName":""}]
             * carList : null
             * carOrder : null
             * carNumber : 粤AX025K
             * carId : 885
             * orderCount : 1
             * payCount : 0
             * totalCount : 6
             * totalPage : null
             */

            private Object code;
            private Object message;
            private Object carList;
            private Object carOrder;
            private String carNumber;
            private String carId;
            private String orderCount;
            private String payCount;
            private String totalCount;
            private Object totalPage;
            private List<ListBean> list;

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

            public Object getCarList() {
                return carList;
            }

            public void setCarList(Object carList) {
                this.carList = carList;
            }

            public Object getCarOrder() {
                return carOrder;
            }

            public void setCarOrder(Object carOrder) {
                this.carOrder = carOrder;
            }

            public String getCarNumber() {
                return carNumber;
            }

            public void setCarNumber(String carNumber) {
                this.carNumber = carNumber;
            }

            public String getCarId() {
                return carId;
            }

            public void setCarId(String carId) {
                this.carId = carId;
            }

            public String getOrderCount() {
                return orderCount;
            }

            public void setOrderCount(String orderCount) {
                this.orderCount = orderCount;
            }

            public String getPayCount() {
                return payCount;
            }

            public void setPayCount(String payCount) {
                this.payCount = payCount;
            }

            public String getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(String totalCount) {
                this.totalCount = totalCount;
            }

            public Object getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(Object totalPage) {
                this.totalPage = totalPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 10
                 * orderId : null
                 * orderNo : null
                 * dispatchNo : 10
                 * carNum : 粤AX025K
                 * carCompanyNo : null
                 * carCompanyName : null
                 * totalPayAmount : null
                 * totalGivePoints : null
                 * serviceCharge : null
                 * singleCharge : null
                 * degreeCharge : null
                 * degree :
                 * status : 0702
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
                 * time :
                 * reason :
                 * count :
                 * latefine :
                 * poundage : null
                 * remark : null
                 * files : null
                 * handleDate : null
                 * orderDate : null
                 * location :
                 * locationName :
                 */

                private String id;
                private Object orderId;
                private Object orderNo;
                private String dispatchNo;
                private String carNum;
                private Object carCompanyNo;
                private Object carCompanyName;
                private Object totalPayAmount;
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
                private String time;
                private String reason;
                private String count;
                private String latefine;
                private Object poundage;
                private Object remark;
                private Object files;
                private Object handleDate;
                private Object orderDate;
                private String location;
                private String locationName;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public Object getOrderId() {
                    return orderId;
                }

                public void setOrderId(Object orderId) {
                    this.orderId = orderId;
                }

                public Object getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(Object orderNo) {
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

                public Object getCarCompanyNo() {
                    return carCompanyNo;
                }

                public void setCarCompanyNo(Object carCompanyNo) {
                    this.carCompanyNo = carCompanyNo;
                }

                public Object getCarCompanyName() {
                    return carCompanyName;
                }

                public void setCarCompanyName(Object carCompanyName) {
                    this.carCompanyName = carCompanyName;
                }

                public Object getTotalPayAmount() {
                    return totalPayAmount;
                }

                public void setTotalPayAmount(Object totalPayAmount) {
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

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
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

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public Object getFiles() {
                    return files;
                }

                public void setFiles(Object files) {
                    this.files = files;
                }

                public Object getHandleDate() {
                    return handleDate;
                }

                public void setHandleDate(Object handleDate) {
                    this.handleDate = handleDate;
                }

                public Object getOrderDate() {
                    return orderDate;
                }

                public void setOrderDate(Object orderDate) {
                    this.orderDate = orderDate;
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
            }
        }
    }
}
