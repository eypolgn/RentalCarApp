package com.example.RentalCar.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {
    private int id;
    private  int userId;
    private  int carId;

    private LocalDate startDate;
    private LocalDate endDate;
}
