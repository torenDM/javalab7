package com.example.energydrinks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "manufacturers")
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
}
