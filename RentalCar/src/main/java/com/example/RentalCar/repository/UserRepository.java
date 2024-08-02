package com.example.RentalCar.repository;

import com.example.RentalCar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
