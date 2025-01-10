package com.todo.taskmanager.controller.AuthController.DTO;

import com.todo.taskmanager.Entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
