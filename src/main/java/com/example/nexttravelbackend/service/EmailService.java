package com.example.nexttravelbackend.service;

import com.example.nexttravelbackend.dto.BookingDTO;

public interface EmailService {
    void sendGuideRegistrationEmail(String email, String fullName);

    void sendBookingConfirmationEmails(BookingDTO dto);
}
