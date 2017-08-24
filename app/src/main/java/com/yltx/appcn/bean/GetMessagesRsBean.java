package com.yltx.appcn.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author：Wq
 * Date：2017/8/24 14:16
 * Description：//todo
 */

public class GetMessagesRsBean {
    /**
     * code : success
     * message : 调用成功
     * data : {"unread":"2","messages":[{"id":"3","title":"处理成功消息","body":"订单cn10245，已办理成功！","sender":"admin","sendTime":"2017-08-24 00:00:00","isReaded":false,"messageType":"2","itemId":"5"},{"id":"4","title":"派单消息","body":"您已到新的订单，请及时办理！车牌号为粤B8888,共计违章5条，扣分8分，罚款总额2500.00元","sender":"admin","sendTime":"2017-08-24 00:00:00","isReaded":false,"messageType":"1","itemId":"4"}]}
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
         * unread : 2
         * messages : [{"id":"3","title":"处理成功消息","body":"订单cn10245，已办理成功！","sender":"admin","sendTime":"2017-08-24 00:00:00","isReaded":false,"messageType":"2","itemId":"5"},{"id":"4","title":"派单消息","body":"您已到新的订单，请及时办理！车牌号为粤B8888,共计违章5条，扣分8分，罚款总额2500.00元","sender":"admin","sendTime":"2017-08-24 00:00:00","isReaded":false,"messageType":"1","itemId":"4"}]
         */

        private String unread;
        private List<MessagesBean> messages;

        public String getUnread() {
            return unread;
        }

        public void setUnread(String unread) {
            this.unread = unread;
        }

        public List<MessagesBean> getMessages() {
            return messages;
        }

        public void setMessages(List<MessagesBean> messages) {
            this.messages = messages;
        }

        public static class MessagesBean implements Serializable{
            /**
             * id : 3
             * title : 处理成功消息
             * body : 订单cn10245，已办理成功！
             * sender : admin
             * sendTime : 2017-08-24 00:00:00
             * isReaded : false
             * messageType : 2
             * itemId : 5
             */

            private String id;
            private String title;
            private String body;
            private String sender;
            private String sendTime;
            private boolean isReaded;
            private String messageType;
            private String itemId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public String getSender() {
                return sender;
            }

            public void setSender(String sender) {
                this.sender = sender;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public boolean isIsReaded() {
                return isReaded;
            }

            public void setIsReaded(boolean isReaded) {
                this.isReaded = isReaded;
            }

            public String getMessageType() {
                return messageType;
            }

            public void setMessageType(String messageType) {
                this.messageType = messageType;
            }

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }
        }
    }
}
