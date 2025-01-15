package com.example.energydrinks.service;

import com.example.energydrinks.model.Drink;
import com.example.energydrinks.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    // Сохранить новый или обновить напиток
    public void saveDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    // Удалить напиток по ID
    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }

    // Получить напиток по ID
    public Drink getDrinkById(Long id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        return drink.orElse(null);
    }

    // Получить все напитки
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
