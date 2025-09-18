package com.example.nexttravelbackend.service;

import jakarta.validation.Valid;
import com.example.nexttravelbackend.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleById(Long id);

    boolean updateVehicleStatus(Long id, String status);

    int deactivateVehicle(String vehicleNumber);

    int activateVehicle(String vehicleNumber);

    List<VehicleDTO> getVehiclesByStatus(String status);

    int saveVehicle(@Valid VehicleDTO vehicleDTO);

    List<VehicleDTO> getAvailableVehicles();

    List<VehicleDTO> getVehiclesByUserEmail(String email);

    int getTotalVehicleCount();

   /* VehicleDTO getVehicleByNumber(String vehicleNumber);

    int updateVehicle(String vehicleNumber, VehicleDTO updatedVehicle);

    boolean deleteVehicle(String vehicleNumber);*/
}
''