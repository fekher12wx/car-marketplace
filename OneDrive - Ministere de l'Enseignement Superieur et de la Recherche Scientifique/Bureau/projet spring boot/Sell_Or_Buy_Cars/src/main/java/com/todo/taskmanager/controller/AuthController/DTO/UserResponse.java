package com.todo.taskmanager.controller.AuthController.DTO;

import com.todo.taskmanager.Entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private  User user;
    private  String message;
}
