package com.example.RentalCar.repository;

import com.example.RentalCar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    void deleteByLicensePlate(String licensePlate);
    Car findByLicensePlate(String licensePlate);
}
