package com.example.nexttravelbackend.controller;

import com.example.nexttravelbackend.dto.DashboardDTO;
import com.example.nexttravelbackend.dto.ResponseDTO;
import com.example.nexttravelbackend.service.BookingService;
import com.example.nexttravelbackend.service.GuideService;
import com.example.nexttravelbackend.service.VehicleService;
import com.example.nexttravelbackend.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GuideService guideService;

    @GetMapping("/counts")
    public ResponseEntity<ResponseDTO> getCounts() {
        try {
            DashboardDTO dto = new DashboardDTO();
            dto.setTotalBookings(bookingService.getTotalBookings());
            dto.setTotalVehicles(vehicleService.getTotalVehicleCount());
            dto.setTotalGuides(guideService.getTotalGuideCount());

            return ResponseEntity.ok(
                    new ResponseDTO(VarList.Created, "Dashboard counts loaded successfully", dto)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @GetMapping("/chart/bookings-per-day")
    public ResponseEntity<ResponseDTO> getBookingsPerDay() {
        try {
            List<Map<String, Object>> data = bookingService.getBookingsPerDay();
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Bookings per day fetched", data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @GetMapping("/chart/total-price-per-booking")
    public ResponseEntity<ResponseDTO> getTotalPricePerBooking() {
        try {
            List<Map<String, Object>> data = bookingService.getTotalPricePerBooking();
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Total price per booking fetched", data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

}
''