package com.example.energydrinks.controller;

import com.example.energydrinks.model.Drink;
import com.example.energydrinks.service.DrinkService;
import com.example.energydrinks.model.Ingredient;
import com.example.energydrinks.model.Manufacturer;
import com.example.energydrinks.repository.DrinkRepository;
import com.example.energydrinks.repository.IngredientRepository;
import com.example.energydrinks.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/drinks")
public class DataViewController {


    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private final DrinkService drinkService;

    @Autowired
    public DataViewController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/drinks")
    public String viewDrinks(Model model) {
        List<Drink> drinks = drinkRepository.findAll();
        model.addAttribute("drinks", drinks);
        return "drinks";
    }

    @GetMapping("/ingredients")
    public String viewIngredients(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }

    @GetMapping("/manufacturers")
    public String viewManufacturers(Model model) {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers";
    }
}
