package com.messenger.controllers;

import com.messenger.models.Message;
import com.messenger.models.User;
import com.messenger.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message sentMessage = chatService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/receive/{userId}")
    public ResponseEntity<List<Message>> receiveMessages(@PathVariable String userId) {
        List<Message> messages = chatService.receiveMessages(userId);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/forward")
    public ResponseEntity<Message> forwardMessage(@RequestBody Message message) {
        Message forwardedMessage = chatService.forwardMessage(message);
        return ResponseEntity.ok(forwardedMessage);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Message>> getChatHistory(@PathVariable String userId) {
        List<Message> chatHistory = chatService.getChatHistory(userId);
        return ResponseEntity.ok(chatHistory);
    }
}