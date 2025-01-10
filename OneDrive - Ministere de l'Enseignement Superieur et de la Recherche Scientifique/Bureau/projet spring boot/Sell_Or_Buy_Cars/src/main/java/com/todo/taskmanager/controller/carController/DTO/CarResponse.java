package com.todo.taskmanager.controller.carController.DTO;

import com.todo.taskmanager.Entity.car.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private Car car;
    private String message;
}
