package com.example.BE_parkee.controller;

import com.example.BE_parkee.entity.Vehicle;
import com.example.BE_parkee.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/check-in")
    public ResponseEntity<Vehicle> checkIn(@RequestBody String plateNumber) {
        try {
            Vehicle vehicle = vehicleService.checkIn(plateNumber);
            return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/check-out")
    public ResponseEntity<Vehicle> checkOut(@RequestBody String plateNumber) {
        try {
            Vehicle vehicle = vehicleService.checkOut(plateNumber);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
