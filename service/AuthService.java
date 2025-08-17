package com.skillwise.backend.service;

import com.skillwise.backend.dto.AuthResponse;
import com.skillwise.backend.dto.LoginRequest;
import com.skillwise.backend.dto.RegisterRequest;
import com.skillwise.backend.model.Role;
import com.skillwise.backend.model.User;
import com.skillwise.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getEmail(),"Register successfully");
    }

    public AuthResponse loginUser(LoginRequest request) {
       try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           request.getEmail(),
                           request.getPassword()
                   )
           );
       }catch (Exception e){

           throw new RuntimeException("Invalid email or password");

       }
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getEmail(),"Login successfully");
    }


}
