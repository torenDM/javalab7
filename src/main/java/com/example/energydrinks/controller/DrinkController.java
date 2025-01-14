package com.example.energydrinks.controller;

import com.example.energydrinks.model.Drink;
import com.example.energydrinks.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping
    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }

    @PostMapping
    public Drink create(@RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        drinkRepository.deleteById(id);
    }

}
