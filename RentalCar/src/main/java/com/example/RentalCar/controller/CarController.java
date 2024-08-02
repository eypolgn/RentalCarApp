package com.example.RentalCar.controller;

import com.example.RentalCar.dto.CarDTO;
import com.example.RentalCar.model.Car;
import com.example.RentalCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable int id) {
        return convertToDto(carService.getCarById(id));
    }

    @PostMapping
    public CarDTO saveCar(@RequestBody CarDTO carDTO) {
        Car car = convertToEntity(carDTO);
        return convertToDto(carService.saveCar(car));
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }

    private CarDTO convertToDto(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setBrand(car.getBrand());
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setPricePerDay(car.getPricePerDay());
        return carDTO;
    }

    private Car convertToEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setBrand(carDTO.getBrand());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setPricePerDay(carDTO.getPricePerDay());
        return car;
    }
}
