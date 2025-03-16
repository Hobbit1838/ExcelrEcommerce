package com.ecommerce.controller;

import com.ecommerce.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<Map<String, String>> checkout(@RequestParam double amount, @RequestParam String paymentMethod) {
        return ResponseEntity.ok(paymentService.processPayment(amount, paymentMethod));
    }
}