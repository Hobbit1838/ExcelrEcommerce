package com.ecommerce.service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ProfileService {
    public Map<String, String> updateProfile(Long userId, String name, String phoneNumber) {
        return Map.of("status", "success", "message", "Profile updated successfully");
    }
}