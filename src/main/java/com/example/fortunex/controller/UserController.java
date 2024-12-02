package com.example.fortunex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fortunex.dto.LoginRequest;
import com.example.fortunex.dto.LoginResponse;
import com.example.fortunex.entities.Users;
import com.example.fortunex.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authorize")  
public class UserController {
// pass : fortuneStone
// username: fortune
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Fetch user from the database
        Users user = userRepository.findByUsername(loginRequest.getUsername());
        
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("Login successful", true));
        }

        return ResponseEntity.status(401).body(new LoginResponse("Invalid credentials", false));
    }
    
}
