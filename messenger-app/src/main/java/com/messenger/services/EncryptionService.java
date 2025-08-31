package com.messenger.services;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    // Simple example, use strong encryption in production!
    public String encrypt(String plainText) {
        return new StringBuilder(plainText).reverse().toString();
    }

    public String decrypt(String cipherText) {
        return new StringBuilder(cipherText).reverse().toString();
    }
}