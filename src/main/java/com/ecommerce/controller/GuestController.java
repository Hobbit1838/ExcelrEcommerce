package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    private final ProductService productService;
    private final Map<String, List<Product>> guestCarts = new HashMap<>();

    public GuestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> viewProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToGuestCart(@RequestParam String sessionId, @RequestBody Product product) {
        guestCarts.putIfAbsent(sessionId, new java.util.ArrayList<>());
        guestCarts.get(sessionId).add(product);
        return ResponseEntity.ok("Product added to guest cart");
    }

    @GetMapping("/cart")
    public ResponseEntity<?> viewGuestCart(@RequestParam String sessionId) {
        return ResponseEntity.ok(guestCarts.getOrDefault(sessionId, new java.util.ArrayList<>()));
    }
}