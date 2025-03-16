package com.ecommerce.service;

import com.ecommerce.model.Wishlist;
import com.ecommerce.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getUserWishlist(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addToWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }
}
