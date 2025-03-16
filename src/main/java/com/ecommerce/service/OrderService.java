package com.ecommerce.service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class OrderService {
    public Map<String, String> placeOrder(Long userId) {
        return Map.of("status", "success", "message", "Order placed successfully");
    }
}

