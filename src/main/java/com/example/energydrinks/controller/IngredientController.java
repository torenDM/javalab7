package com.example.energydrinks.controller;

import com.example.energydrinks.model.Ingredient;
import com.example.energydrinks.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Просмотр всех ингредиентов
    @GetMapping
    public String getAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "ingredients/index";
    }

    // Страница для добавления нового ингредиента
    @GetMapping("/new")
    public String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/form";
    }

    // Обработка формы добавления нового ингредиента
    @PostMapping("/save")
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredients";
    }

    // Страница для редактирования ингредиента
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        model.addAttribute("ingredient", ingredient);
        return "ingredients/form";
    }

    // Обработка формы редактирования ингредиента
    @PostMapping("/update/{id}")
    public String updateIngredient(@PathVariable("id") Long id, @ModelAttribute Ingredient ingredient) {
        ingredient.setId(id);
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredients";
    }

    // Удаление ингредиента
    @GetMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredients";
    }
}