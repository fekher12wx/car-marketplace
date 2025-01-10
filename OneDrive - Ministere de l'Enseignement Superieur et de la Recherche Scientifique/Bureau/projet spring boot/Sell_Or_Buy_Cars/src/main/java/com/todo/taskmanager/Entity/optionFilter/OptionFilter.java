package com.todo.taskmanager.Entity.optionFilter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "option_filters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionFilter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private String yearRange;
    private String priceRange;
}