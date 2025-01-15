package com.example.energydrinks.controller;

import com.example.energydrinks.model.Drink;
import com.example.energydrinks.model.Ingredient;
import com.example.energydrinks.model.Manufacturer;
import com.example.energydrinks.service.DrinkService;
import com.example.energydrinks.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkService drinkService;
    private final ManufacturerService manufacturerService; // Добавить сервис для производителей

    @Autowired
    public DrinkController(DrinkService drinkService, ManufacturerService manufacturerService) {
        this.drinkService = drinkService;
        this.manufacturerService = manufacturerService; // Инициализация сервиса
    }

    // Страница со списком всех напитков
    @GetMapping
    public String getAllDrinks(Model model) {
        model.addAttribute("drinks", drinkService.getAllDrinks());
        return "drinks/index";  // Путь к шаблону для отображения списка напитков
    }

    // Форма для добавления нового напитка
    @GetMapping("/new")
    public String createDrinkForm(Model model) {
        model.addAttribute("drink", new Drink());  // Создаем пустой объект Drink для формы

        // Получаем список производителей и добавляем в модель
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("manufacturers", manufacturers);

        return "drinks/form";  // Путь к форме для добавления напитка
    }

    // Сохранение нового или отредактированного напитка
    @PostMapping("/save")
    public String saveDrink(@ModelAttribute Drink drink) {
        drinkService.saveDrink(drink);
        return "redirect:/drinks";
    }

    // Форма для редактирования напитка
    @GetMapping("/edit/{id}")
    public String editDrinkForm(@PathVariable("id") Long id, Model model) {
        Drink drink = drinkService.getDrinkById(id);
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("drink", drink);
        return "drinks/form";  // Путь к форме для редактирования напитка
    }

    // Обработка формы редактирования ингредиента
    @PostMapping("/update/{id}")
    public String updateIngredient(@PathVariable("id") Long id, @ModelAttribute Drink drink) {
        drink.setId(id);
        drinkService.saveDrink(drink);
        return "redirect:/drinks";
    }

    // Удаление напитка
    @GetMapping("/delete/{id}")
    public String deleteDrink(@PathVariable("id") Long id) {
        drinkService.deleteDrink(id);
        return "redirect:/drinks";
    }
}
