package com.example.energydrinks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
}