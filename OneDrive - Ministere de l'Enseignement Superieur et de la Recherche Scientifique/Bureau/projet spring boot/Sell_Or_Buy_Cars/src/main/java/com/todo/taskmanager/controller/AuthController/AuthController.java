package com.todo.taskmanager.controller.AuthController;

import com.todo.taskmanager.controller.AuthController.DTO.*;
import com.todo.taskmanager.controller.AuthController.Exception.EmailAlreadyExistsException;
import com.todo.taskmanager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private   AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ){
        try{
            return ResponseEntity.ok(service.register(request));
            
        }catch (EmailAlreadyExistsException ea){
            AuthenticationResponse errorReponse = AuthenticationResponse.builder()
                    .message(ea.getMessage())
                    .build();
            return ResponseEntity.status(401).body(errorReponse);
        }catch (Exception e){
            AuthenticationResponse errorReponse = AuthenticationResponse.builder()
                    .message("Register failed"+e.getMessage())
                    .build();
            return ResponseEntity.status(500).body(errorReponse);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody AuthenticationRequest request
    ){
        try {
            return ResponseEntity.ok(service.login(request));
        }catch (BadCredentialsException be){
            AuthenticationResponse errorResponse= AuthenticationResponse.builder()
                    .message("Invalid email or password!")
                    .build();
            return ResponseEntity.status(401).body(errorResponse);
        }catch (Exception e){
            AuthenticationResponse errorResponse= AuthenticationResponse.builder()
                    .message("Authentication failed"+e.getMessage())
                    .build();
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
    @GetMapping("/id/{id}")
    public  ResponseEntity<UserResponse> RetrieveUserById (@PathVariable Long id){
        return  ResponseEntity.ok(service.getUserById(id));
    }
    @GetMapping("/email/{email}")
    public  ResponseEntity<UserResponse> RetrieveUserByEmail (@PathVariable String email){
        return  ResponseEntity.ok(service.getUserByEmail(email));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        boolean isDeleted = service.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }
    @PutMapping("/update/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {

        return ResponseEntity.ok(service.updateUser(id, request));
    }

}
