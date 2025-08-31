package com.messenger.services;

import com.messenger.models.*;
import com.messenger.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private NotificationService notificationService;

    // Send a text message
    public Message sendMessage(String senderUsername, String receiverUsername, String content) {
        User sender = userRepository.findByUsername(senderUsername);
        User receiver = userRepository.findByUsername(receiverUsername);
        String encryptedContent = encryptionService.encrypt(content);

        Message message = new Message(null, sender, receiver, encryptedContent, LocalDateTime.now(), false, null);
        Message saved = messageRepository.save(message);

        notificationService.notifyUser(receiverUsername, "New message from " + senderUsername);
        return saved;
    }

    // Send media message
    public Message sendMediaMessage(String senderUsername, String receiverUsername, String type, String url) {
        User sender = userRepository.findByUsername(senderUsername);
        User receiver = userRepository.findByUsername(receiverUsername);

        Media media = new Media(null, type, url);
        mediaRepository.save(media);

        Message message = new Message(null, sender, receiver, "[Media]", LocalDateTime.now(), false, media);
        Message saved = messageRepository.save(message);

        notificationService.notifyUser(receiverUsername, "New media from " + senderUsername);
        return saved;
    }

    // Forward a message
    public Message forwardMessage(Long messageId, String newReceiverUsername) {
        Message original = messageRepository.findById(messageId).orElseThrow();
        User newReceiver = userRepository.findByUsername(newReceiverUsername);

        Message forwarded = new Message(null, original.getSender(), newReceiver, original.getContent(), LocalDateTime.now(), true, original.getMedia());
        Message saved = messageRepository.save(forwarded);

        notificationService.notifyUser(newReceiverUsername, "Message forwarded from " + original.getSender().getUsername());
        return saved;
    }

    // Get messages for a user
    public List<Message> getMessages(String username) {
        User user = userRepository.findByUsername(username);
        List<Message> messages = messageRepository.findByReceiver(user);
        // Decrypt content
        messages.forEach(m -> m.setContent(encryptionService.decrypt(m.getContent())));
        return messages;
    }

    // Group chat: send message to multiple users
    public List<Message> sendGroupMessage(String senderUsername, List<String> receiverUsernames, String content) {
        User sender = userRepository.findByUsername(senderUsername);
        String encryptedContent = encryptionService.encrypt(content);
        List<Message> sentMessages = receiverUsernames.stream().map(receiverUsername -> {
            User receiver = userRepository.findByUsername(receiverUsername);
            Message message = new Message(null, sender, receiver, encryptedContent, LocalDateTime.now(), false, null);
            notificationService.notifyUser(receiverUsername, "Group message from " + senderUsername);
            return messageRepository.save(message);
        }).toList();
        return sentMessages;
    }
}