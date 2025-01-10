package com.todo.taskmanager.Entity.advertisement;

import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.Entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    private AdStatus status;

    private LocalDateTime datePosted;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}