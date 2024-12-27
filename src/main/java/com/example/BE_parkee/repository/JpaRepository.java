package com.example.BE_parkee.repository;

import com.example.BE_parkee.entity.Vehicle;

public interface JpaRepository<T, T1> {
    Vehicle save(Vehicle vehicle);
}
