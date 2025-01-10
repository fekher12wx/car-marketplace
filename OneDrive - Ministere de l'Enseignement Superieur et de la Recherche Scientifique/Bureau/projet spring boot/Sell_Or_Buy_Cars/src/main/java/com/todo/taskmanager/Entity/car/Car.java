package com.todo.taskmanager.Entity.car;

import com.todo.taskmanager.Entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private Integer year;
    private BigDecimal price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private User vendor;
}