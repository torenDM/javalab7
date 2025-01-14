package com.example.energydrinks.controller;

import com.example.energydrinks.model.Manufacturer;
import com.example.energydrinks.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    // Просмотр всех производителей
    @GetMapping
    public String getAllManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "manufacturers/index";
    }

    // Страница для добавления нового производителя
    @GetMapping("/new")
    public String showManufacturerForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturers/form";
    }

    // Обработка формы добавления нового производителя
    @PostMapping("/save")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        if (manufacturer.getCountry() == null || manufacturer.getCountry().isEmpty()) {
            // Вы можете выбросить исключение или вернуть ошибку
            return "redirect:/manufacturers?error=countryMissing";
        }
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }


    // Страница для редактирования производителя
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturers/form";
    }

    // Обработка формы редактирования производителя
    @PostMapping("/update/{id}")
    public String updateManufacturer(@PathVariable("id") Long id, @ModelAttribute Manufacturer manufacturer) {
        manufacturer.setId(id);
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }

    // Удаление производителя
    @GetMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id) {
        manufacturerService.deleteManufacturer(id);
        return "redirect:/manufacturers";
    }
}
