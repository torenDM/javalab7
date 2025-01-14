package com.example.energydrinks.repository;

import com.example.energydrinks.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}

