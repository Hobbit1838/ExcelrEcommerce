package com.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @PostMapping("/manage-user")
    public ResponseEntity<Map<String, String>> manageUser(@RequestParam String action, @RequestParam Long userId) {
        return ResponseEntity.ok(Map.of("message", "User " + action + " successfully"));
    }

    @PostMapping("/manage-product")
    public ResponseEntity<Map<String, String>> manageProduct(@RequestParam String action, @RequestParam Long productId) {
        return ResponseEntity.ok(Map.of("message", "Product " + action + " successfully"));
    }
}