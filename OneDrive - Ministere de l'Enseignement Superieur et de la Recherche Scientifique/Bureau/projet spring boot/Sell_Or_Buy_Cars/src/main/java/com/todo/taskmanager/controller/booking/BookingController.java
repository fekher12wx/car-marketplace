package com.todo.taskmanager.controller.booking;

import com.todo.taskmanager.Entity.booking.BookStatus;
import com.todo.taskmanager.Entity.booking.Booking;
import com.todo.taskmanager.controller.booking.DTO.BookingRequest;
import com.todo.taskmanager.controller.booking.DTO.BookingResponse;
import com.todo.taskmanager.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/schedule")
    public ResponseEntity<BookingResponse> scheduleTestDrive(@RequestBody BookingRequest request) {
        BookingResponse response = bookingService.scheduleTestDrive(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {
        BookingResponse response = bookingService.getBookingById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> responses = bookingService.getBookingsByUser(userId);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBookingStatus(
            @PathVariable Long id,
            @RequestParam BookStatus status) {
        BookingResponse response = bookingService.updateBookingStatus(id, status);
        return ResponseEntity.ok(response);
    }

}