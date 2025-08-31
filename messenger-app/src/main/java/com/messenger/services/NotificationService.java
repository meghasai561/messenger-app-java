package com.messenger.services;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<String> notifications;

    public NotificationService() {
        this.notifications = new ArrayList<>();
    }

    public void sendNotification(String message) {
        notifications.add(message);
        // Logic to send push notification to the user
        System.out.println("Notification sent: " + message);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void clearNotifications() {
        notifications.clear();
    }
}