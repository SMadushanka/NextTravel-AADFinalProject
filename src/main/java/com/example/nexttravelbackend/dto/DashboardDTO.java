package com.example.nexttravelbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {

    private int totalBookings;
    private int totalVehicles;
    private int totalGuides;
}
