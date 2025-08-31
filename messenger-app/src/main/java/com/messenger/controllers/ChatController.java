package com.messenger.controllers;

import com.messenger.models.Message;
import com.messenger.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public Message sendMessage(@RequestParam String sender, @RequestParam String receiver, @RequestParam String content) {
        return chatService.sendMessage(sender, receiver, content);
    }

    @PostMapping("/sendMedia")
    public Message sendMedia(@RequestParam String sender, @RequestParam String receiver, @RequestParam String type, @RequestParam String url) {
        return chatService.sendMediaMessage(sender, receiver, type, url);
    }

    @PostMapping("/forward")
    public Message forwardMessage(@RequestParam Long messageId, @RequestParam String newReceiver) {
        return chatService.forwardMessage(messageId, newReceiver);
    }

    @GetMapping("/messages")
    public List<Message> getMessages(@RequestParam String username) {
        return chatService.getMessages(username);
    }

    @PostMapping("/group")
    public List<Message> sendGroupMessage(@RequestParam String sender, @RequestBody List<String> receivers, @RequestParam String content) {
        return chatService.sendGroupMessage(sender, receivers, content);
    }
}