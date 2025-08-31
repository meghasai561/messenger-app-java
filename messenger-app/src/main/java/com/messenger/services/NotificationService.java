package com.messenger.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public void notifyUser(String username, String message) {
        // In production, integrate with push notification service
        System.out.println("Notify " + username + ": " + message);
    }
}