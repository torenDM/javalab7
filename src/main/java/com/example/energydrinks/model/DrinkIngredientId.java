package com.example.energydrinks.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DrinkIngredientId implements Serializable {

    private Long drink;
    private Long ingredient;

    public DrinkIngredientId() {}

    public DrinkIngredientId(Long drink, Long ingredient) {
        this.drink = drink;
        this.ingredient = ingredient;
    }

    public Long getDrink() {
        return drink;
    }

    public void setDrink(Long drink) {
        this.drink = drink;
    }

    public Long getIngredient() {
        return ingredient;
    }

    public void setIngredient(Long ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkIngredientId that = (DrinkIngredientId) o;
        return Objects.equals(drink, that.drink) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drink, ingredient);
    }
}
