package com.example.RentalCar.service;

import com.example.RentalCar.model.Reservation;
import com.example.RentalCar.repository.ReservationRepository;
import com.example.RentalCar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id){
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(int id){
        reservationRepository.deleteById(id);
    }
}
