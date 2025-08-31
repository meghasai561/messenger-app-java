package com.messenger.services;

import com.messenger.models.Message;
import com.messenger.models.User;
import com.messenger.db.DatabaseManager;

import java.util.List;

public class ChatService {

    private DatabaseManager databaseManager;

    public ChatService(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void sendMessage(Message message) {
        // Logic to send a message
        databaseManager.saveMessage(message);
        // Notify recipient
        // Trigger push notification
    }

    public List<Message> receiveMessages(User user) {
        // Logic to receive messages for a user
        return databaseManager.getMessagesForUser(user);
    }

    public void forwardMessage(Message message, User newReceiver) {
        // Logic to forward a message
        Message forwardedMessage = new Message(message);
        forwardedMessage.setReceiverId(newReceiver.getUserId());
        databaseManager.saveMessage(forwardedMessage);
        // Notify new receiver
        // Trigger push notification
    }

    public List<Message> getChatHistory(User userA, User userB) {
        // Logic to retrieve chat history between two users
        return databaseManager.getChatHistory(userA, userB);
    }
}