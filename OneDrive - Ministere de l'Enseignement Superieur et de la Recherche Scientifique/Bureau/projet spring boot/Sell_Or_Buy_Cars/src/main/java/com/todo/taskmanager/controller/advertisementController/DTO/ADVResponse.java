package com.todo.taskmanager.controller.advertisementController.DTO;

import com.todo.taskmanager.Entity.advertisement.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ADVResponse {
    private Advertisement advertisement;
    private String message;
}
