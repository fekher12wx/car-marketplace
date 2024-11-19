package com.tp.carsseller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private Integer year;
    private Integer kilometerage;
    private String fuelType;
    private String transmission;
    private String bodyType;
    private String color;
    private String condition;
}
