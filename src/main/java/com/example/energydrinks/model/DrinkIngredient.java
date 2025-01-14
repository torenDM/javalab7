package com.example.energydrinks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DrinkIngredient {

    @EmbeddedId
    private DrinkIngredientId id;

    @ManyToOne
    @MapsId("drink")
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @ManyToOne
    @MapsId("ingredient")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private double quantity;
}
