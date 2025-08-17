package com.skillwise.backend.controller;

import com.skillwise.backend.dto.AuthResponse;
import com.skillwise.backend.dto.LoginRequest;
import com.skillwise.backend.dto.RegisterRequest;
import com.skillwise.backend.repository.UserRepository;
import com.skillwise.backend.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//CONTROLLER FOR AUTHENTICATION RELATED ENDPOINT
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@EnableMethodSecurity
public class AuthController {

    private final AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "  - Register User -")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
       try {
           AuthResponse response = authService.registerUser(request);
           return ResponseEntity.ok(response);
       }catch (RuntimeException e){
           return ResponseEntity.badRequest().body(new AuthResponse(null,e.getMessage(),"Check all details"));
       }
    }

    @Operation(summary = "  - Login User -")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            AuthResponse response = authService.loginUser(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new AuthResponse(null, e.getMessage(),"Check all details"));
        }
    }

}

