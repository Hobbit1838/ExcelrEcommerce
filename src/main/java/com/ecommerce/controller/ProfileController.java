package com.ecommerce.controller;

import com.ecommerce.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateProfile(@RequestParam Long userId, @RequestParam String name, @RequestParam String phoneNumber) {
        return ResponseEntity.ok(profileService.updateProfile(userId, name, phoneNumber));
    }
}