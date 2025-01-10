package com.todo.taskmanager.repository;

import com.todo.taskmanager.Entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
