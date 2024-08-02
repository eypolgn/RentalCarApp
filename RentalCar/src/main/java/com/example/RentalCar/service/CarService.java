package com.example.RentalCar.service;

import com.example.RentalCar.model.Car;
import com.example.RentalCar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarById(int id){
        return carRepository.findById(id).orElse(null);
    }

    public  Car saveCar(Car car){
        return carRepository.save(car);
    }

    public void deleteCar(int id){
        carRepository.deleteById(id);
    }
}
