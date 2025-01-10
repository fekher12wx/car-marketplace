package com.todo.taskmanager.service;

import com.todo.taskmanager.config.JwtService;
import com.todo.taskmanager.controller.AuthController.DTO.AuthenticationRequest;
import com.todo.taskmanager.controller.AuthController.DTO.AuthenticationResponse;
import com.todo.taskmanager.controller.AuthController.DTO.UpdateUserRequest;
import com.todo.taskmanager.controller.AuthController.DTO.UserResponse;
import com.todo.taskmanager.controller.AuthController.DTO.RegisterRequest;
import com.todo.taskmanager.controller.AuthController.Exception.EmailAlreadyExistsException;
import com.todo.taskmanager.repository.UserRepository;
import com.todo.taskmanager.Entity.user.Role;
import com.todo.taskmanager.Entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthService {
    @Autowired
    private  UserRepository repository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()){
            throw  new EmailAlreadyExistsException("Email already registred: "+request.getEmail());
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .build();
        repository.save(user);

        var jwtToken= jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                    .message("Register Successfully")
                    .token(jwtToken)
                    .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var user = repository.findByEmail(request.getEmail())
                    .orElseThrow();

            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("Login Successfully")
                    .build();
    }

    public UserResponse getUserById(Long id) {
        try {
           var user = repository.findById(id)
                   .orElseThrow(() -> new RuntimeException("User not found!"));

           return UserResponse.builder()
                   .user(user)
                   .message("User found")
                   .build();
       }catch (RuntimeException ex){
           return  UserResponse.builder()
                   .message(ex.getMessage())
                   .build();
       }
   }

    public UserResponse getUserByEmail(String email) {
        try {
            var user = repository.findByEmail(email)
                    .orElseThrow(()->new RuntimeException("User not found"));
            return UserResponse.builder()
                    .user(user)
                    .message("User found")
                    .build();

        }catch (RuntimeException ex)
        {
            return  UserResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    public boolean deleteUserById(Long id) {
        var user = repository.findById(id);
        if (user.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
       try {
           var existingUser = repository.findById(id)
                   .orElseThrow(()->new RuntimeException("User not found!"));
           if (!existingUser.getEmail().equals(request.getEmail()) && repository.findByEmail(request.getEmail()).isPresent()){
                throw new RuntimeException("Email already exists !");
           }
           existingUser.setFirstname(request.getFirstname());
           existingUser.setLastname(request.getLastname());
           existingUser.setEmail(request.getEmail());
           existingUser.setPassword(passwordEncoder.encode(request.getPassword()));

           repository.save(existingUser);

           return  UserResponse.builder()
                   .user(existingUser)
                   .message("User updated successfully")
                   .build();
       }catch (RuntimeException ex)
       {
           return  UserResponse.builder()
                   .message(ex.getMessage())
                   .build();
       }
    }
}

