package com.example.BE_parkee.entity;

import java.time.LocalDateTime;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String plateNumber;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private BigDecimal totalPrice;

    public void setPlateNumber(String plateNumber) {
    }

    public void setCheckInTime(LocalDateTime now) {
    }

    // Getters and Setters
}
