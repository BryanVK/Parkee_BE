package com.example.BE_parkee.service;

import com.example.BE_parkee.entity.Vehicle;
import com.example.BE_parkee.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle checkIn(String plateNumber) {
        if(vehicleRepository.findByPlateNumber(plateNumber).isPresent()) {
            throw new IllegalStateException("Vehicle with this plate number is already in the parking.");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNumber(plateNumber);
        vehicle.setCheckInTime(LocalDateTime.now());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle checkOut(String plateNumber) {
        Vehicle vehicle = vehicleRepository.findByPlateNumber(plateNumber)
                .orElseThrow(() -> new IllegalStateException("No vehicle found with this plate number."));

        vehicle.setCheckOutTime(LocalDateTime.now());

        // Calculate price (3000 per hour)
        long hoursParked = Duration.between(vehicle.getCheckInTime(), vehicle.getCheckOutTime()).toHours();
        BigDecimal totalPrice = BigDecimal.valueOf(hoursParked).multiply(BigDecimal.valueOf(3000));
        vehicle.setTotalPrice(totalPrice);

        return vehicleRepository.save(vehicle);
    }
}
