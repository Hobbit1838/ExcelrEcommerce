package com.ecommerce.controller;

import com.ecommerce.model.Wishlist;
import com.ecommerce.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Wishlist>> getWishlist(@PathVariable Long userId) {
        return ResponseEntity.ok(wishlistService.getUserWishlist(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<Wishlist> addToWishlist(@RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistService.addToWishlist(wishlist));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable Long id) {
        wishlistService.removeFromWishlist(id);
        return ResponseEntity.ok("Item removed from wishlist");
    }
}
