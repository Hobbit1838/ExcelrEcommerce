package com.ecommerce.controller;

import com.ecommerce.model.OrderHistory;
import com.ecommerce.service.OrderHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order-history")
public class OrderHistoryController {
    private final OrderHistoryService orderHistoryService;

    public OrderHistoryController(OrderHistoryService orderHistoryService) {
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderHistory>> getOrderHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(orderHistoryService.getUserOrderHistory(userId));
    }
}
