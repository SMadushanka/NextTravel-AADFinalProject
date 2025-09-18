package com.example.nexttravelbackend.config;

import com.example.nexttravelbackend.entity.Booking;
import com.example.nexttravelbackend.entity.Guide;
import com.example.nexttravelbackend.entity.Vehicle;
import com.example.nexttravelbackend.repo.BookingRepository;
import com.example.nexttravelbackend.repo.GuideRepository;
import com.example.nexttravelbackend.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookingStatusScheduler {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private GuideRepository guideRepository;

    @Scheduled(cron = "0 * * * * ?") // every minute
    public void updateBookingStatus() {
        LocalDate today = LocalDate.now();

        List<Booking> completedBookings = bookingRepository.findByCheckoutDateLessThanEqualAndActive(today, true);

        for (Booking booking : completedBookings) {
            Vehicle vehicle = booking.getVehicle();
            Guide guide = booking.getGuide();

            if (vehicle != null) {
                vehicle.setBooked("NO");
                vehicleRepository.save(vehicle);
            }

            if (guide != null) {
                guide.setBooked("NO");
                guideRepository.save(guide);
            }

            booking.setActive(false); // Optional: mark booking as completed
            bookingRepository.save(booking);
        }
    }
}

