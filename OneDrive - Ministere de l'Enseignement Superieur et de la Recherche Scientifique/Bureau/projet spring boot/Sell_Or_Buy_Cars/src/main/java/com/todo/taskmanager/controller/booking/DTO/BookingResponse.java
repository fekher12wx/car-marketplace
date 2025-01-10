package com.todo.taskmanager.controller.booking.DTO;

import com.todo.taskmanager.Entity.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Booking booking;
    private String message;
}
