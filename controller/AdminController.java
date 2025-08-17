package com.skillwise.backend.controller;

import com.skillwise.backend.model.Role;
import com.skillwise.backend.model.User;
import com.skillwise.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserRepository userRepository;

    @Operation(summary = "  - Check User Active Or Not -")
    @PutMapping("/user/{id}/role")
    public ResponseEntity<?> updateUserRole(@PathVariable Long id,
                                            @RequestParam("role") String role,
                                            @RequestParam(value = "enable" , required = false,defaultValue = "true")boolean isEnabled){
        try{
            Optional<User> userOptional  =userRepository.findById(id);
            if(userOptional.isEmpty()){
                return ResponseEntity.status(404).body("User not found with ID: "+ id);
            }
            User user = userOptional.get();
            user.setRole(Role.valueOf(role.toUpperCase()));
            user.setEnabled(isEnabled);
            userRepository.save(user);

            String status = isEnabled ? "activated" : " deactivated";
            return ResponseEntity.ok("User role update to " + role + " and user is "+status);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Invalid role :"+role);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error while updating user: "+ e.getMessage() );
        }
    }

    @Operation(summary = "  - Get All Details User -")
    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return  userOptional.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("User not found"));
    }
}
