package com.messenger.models;

public class User {
    private String userId;
    private String username;
    private String contactInfo;

    public User(String userId, String username, String contactInfo) {
        this.userId = userId;
        this.username = username;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}