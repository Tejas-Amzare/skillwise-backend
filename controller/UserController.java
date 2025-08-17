package com.skillwise.backend.controller;

import com.skillwise.backend.dto.UserResponseDto;
import com.skillwise.backend.model.User;
import com.skillwise.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @Operation(summary = "  - Get User Profile -")
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseDto response = new UserResponseDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole().name()
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "  - Update User Name -")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UserResponseDto updateUser){
        try {
            Optional<User> optionalUser = userRepository.findById(id);

            if (optionalUser.isPresent()) {

                User user = optionalUser.get();

                user.setFullName(updateUser.getFullName());
                userRepository.save(user);

                UserResponseDto response = new UserResponseDto(
                        user.getId(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getRole().name()
                );
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(404).body("User not found with ID:" + id);
            }
        }catch(Exception e){
                return ResponseEntity.status(500).body("Failde to update user : " + e.getMessage());
            }
        }

    @Operation(summary = "  - Delete User Using Valid Id -")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deletedByUserId(@PathVariable Long id) {

        try{
            Optional<User> userOptional = userRepository.findById(id);

            if(userOptional.isPresent()){
                userRepository.delete(userOptional.get());
                return ResponseEntity.ok("User successfully deleted using this ID :- "+id);
            }else {
                return ResponseEntity.status(404).body("User id not found :-[ "+ id +" ]-: Try the correct id");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error occurrence while deleting user :- "+ e.getMessage());
        }

    }

    @Operation(summary = "  - Get All User -")
    @GetMapping("/allUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllUser(){

        List<UserResponseDto> users = userRepository.findAll().stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getRole().name()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
