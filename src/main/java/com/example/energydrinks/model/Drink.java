package com.example.energydrinks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "drinks")
@Data
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int volumeMl;
    private int caffeineMg;
    private double price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
