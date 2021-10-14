package com.androidDev.ichat.Model;

public class notificationModel {

    int profile;
    String notificationdata,notificationtime;

    public notificationModel(int profile, String notificationdata, String notificationtime) {
        this.profile = profile;
        this.notificationdata = notificationdata;
        this.notificationtime = notificationtime;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getNotificationdata() {
        return notificationdata;
    }

    public void setNotificationdata(String notificationdata) {
        this.notificationdata = notificationdata;
    }

    public String getNotificationtime() {
        return notificationtime;
    }

    public void setNotificationtime(String notificationtime) {
        this.notificationtime = notificationtime;
    }
}
