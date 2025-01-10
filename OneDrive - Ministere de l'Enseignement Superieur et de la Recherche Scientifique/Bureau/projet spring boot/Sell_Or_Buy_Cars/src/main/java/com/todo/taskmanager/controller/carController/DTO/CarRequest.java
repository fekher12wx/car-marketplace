package com.todo.taskmanager.controller.carController.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private BigDecimal price;
    private String description;
}
