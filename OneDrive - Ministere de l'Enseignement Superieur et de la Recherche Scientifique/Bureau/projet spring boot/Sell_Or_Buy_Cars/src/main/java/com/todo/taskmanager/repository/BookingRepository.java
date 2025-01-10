package com.todo.taskmanager.repository;

import com.todo.taskmanager.Entity.booking.Booking;
import com.todo.taskmanager.Entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByClient(User client);
}
