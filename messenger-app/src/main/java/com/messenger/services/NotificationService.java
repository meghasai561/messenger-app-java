package com.messenger.services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(String username, String message) {
        // In production, integrate with push notification service
        System.out.println("Notify " + username + ": " + message);
    }
}