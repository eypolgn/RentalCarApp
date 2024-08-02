package com.example.RentalCar.dto;

import lombok.Data;

@Data
public class CarDTO {
    private int id;
    private String model;
    private String brand;
    private String licensePlate;
    private double pricePerDay;
}
