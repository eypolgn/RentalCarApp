package com.example.RentalCar.controller;

import com.example.RentalCar.dto.ReservationDTO;
import com.example.RentalCar.model.Car;
import com.example.RentalCar.model.Reservation;
import com.example.RentalCar.model.User;
import com.example.RentalCar.service.CarService;
import com.example.RentalCar.service.ReservationService;
import com.example.RentalCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable int id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(reservation));
    }

    @PostMapping
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = convertToEntity(reservationDTO);
        return convertToDto(reservationService.saveReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }

    private ReservationDTO convertToDto(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setUserId(reservation.getUser().getId());
        reservationDTO.setCarId(reservation.getCar().getId());
        reservationDTO.setStartDate(reservation.getStartDate());
        reservationDTO.setEndDate(reservation.getEndDate());
        return reservationDTO;
    }

    private Reservation convertToEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setEndDate(reservationDTO.getEndDate());

        User user = userService.getUserById(reservationDTO.getUserId());
        Car car = carService.getCarById(reservationDTO.getCarId());

        reservation.setUser(user);
        reservation.setCar(car);

        return reservation;
    }
}
