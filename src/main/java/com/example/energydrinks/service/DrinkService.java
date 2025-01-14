package com.example.energydrinks.service;

import com.example.energydrinks.model.Drink;
import com.example.energydrinks.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public void saveDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }

    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id).orElse(null);
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
