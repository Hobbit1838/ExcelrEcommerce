package com.ecommerce.service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentService {
    public Map<String, String> processPayment(double amount, String paymentMethod) {
        // Simulating payment processing
        if (amount > 0) {
            return Map.of("status", "success", "message", "Payment of " + amount + " processed via " + paymentMethod);
        }
        return Map.of("status", "failed", "message", "Invalid payment amount");
    }
}
