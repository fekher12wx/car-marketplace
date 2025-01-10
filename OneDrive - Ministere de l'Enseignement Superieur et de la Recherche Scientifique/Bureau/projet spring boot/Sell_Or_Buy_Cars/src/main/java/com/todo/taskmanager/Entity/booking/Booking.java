package com.todo.taskmanager.Entity.booking;

import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.Entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private BookStatus status;


}