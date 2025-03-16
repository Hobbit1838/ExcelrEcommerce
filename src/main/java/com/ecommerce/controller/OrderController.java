package com.ecommerce.controller;

import com.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestParam Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }
}