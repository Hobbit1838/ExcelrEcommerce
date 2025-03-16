package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;  // ✅ Use PasswordEncoder
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, String> registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // ✅ Use passwordEncoder
        userRepository.save(user);
        return Map.of("message", "User registered successfully");
    }

    public Map<String, String> login(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            String token = jwtUtil.generateToken(existingUser.getEmail(), existingUser.getRoles().iterator().next());
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public Map<String, String> assignRole(String email, String role) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.getRoles().add(role);
        userRepository.save(user);
        return Map.of("message", "Role assigned successfully");
    }
}
