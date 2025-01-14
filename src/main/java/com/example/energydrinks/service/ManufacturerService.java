package com.example.energydrinks.service;

import com.example.energydrinks.model.Manufacturer;
import com.example.energydrinks.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(Long id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
