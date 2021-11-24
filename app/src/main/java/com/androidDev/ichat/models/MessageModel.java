package com.androidDev.ichat.models;

public class MessageModel {
    String uId,message,messageId;

    public MessageModel( ){

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public MessageModel(String uId, String message) {
        this.uId = uId;
        this.message = message;
    }

    public MessageModel(String uId, String message, String messageId) {

        this.uId = uId;
        this.message = message;
        this.messageId = messageId;
    }
}
