package com.todo.taskmanager.service;

import com.todo.taskmanager.Entity.booking.BookStatus;
import com.todo.taskmanager.Entity.booking.Booking;
import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.Entity.user.User;
import com.todo.taskmanager.controller.booking.DTO.BookingRequest;
import com.todo.taskmanager.controller.booking.DTO.BookingResponse;
import com.todo.taskmanager.repository.BookingRepository;
import com.todo.taskmanager.repository.CarRepository;
import com.todo.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BookingResponse scheduleTestDrive(BookingRequest request) {
        try {
            var car = carRepository.findById(request.getCarId())
                    .orElseThrow(() -> new RuntimeException("Car not found"));

            var client = userRepository.findById(request.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));

            Booking booking = new Booking();
            booking.setCar(car);
            booking.setClient(client);
            booking.setDate(request.getDate() != null ? request.getDate() : LocalDateTime.now());
            booking.setStatus(BookStatus.SCHEDULED);

            bookingRepository.save(booking);

            return BookingResponse.builder()
                    .booking(booking)
                    .message("Booking scheduled successfully")
                    .build();
        } catch (RuntimeException ex) {
            return BookingResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    public BookingResponse getBookingById(Long id) {
        try {
            var booking = bookingRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Booking not found"));
            return BookingResponse.builder()
                    .booking(booking)
                    .message("Booking found")
                    .build();
        }catch (RuntimeException ex)
        {
            return BookingResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    public List<Booking> getBookingsByUser(Long userId) {
        var client = userRepository.findById(userId).
                orElseThrow(()->new RuntimeException("Client not found"));
        return bookingRepository.findByClient(client);
    }

    public BookingResponse updateBookingStatus(Long id,BookStatus status) {
        try {
            var booking = bookingRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Booking not found"));
            booking.setStatus(status);
            bookingRepository.save(booking);
            return BookingResponse.builder()
                    .booking(booking)
                    .message("Booking updated successfully")
                    .build();
        }catch (RuntimeException ex)
        {
            return BookingResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }
}
