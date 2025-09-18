package com.example.nexttravelbackend.service;

import com.example.nexttravelbackend.dto.BookingDTO;

import java.util.List;
import java.util.Map;

public interface BookingService {
    boolean saveBooking(BookingDTO dto);

    int getTotalBookings();

    List<BookingDTO> getAllBookings();

    List<BookingDTO> getBookingsByUserEmail(String email);

    List<Map<String, Object>> getBookingsPerDay();

    List<Map<String, Object>> getTotalPricePerBooking();
}
