package com.floristeria.project.domain;

/**
 * Clase de la capa Domain
 *
 */
public class Flower extends Price{
    private String color;

       public Flower(String color) {
        this.color = color;
    }

    @Override
    public double cost() {
        return PRICE_FLOWER;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\tColor ='" + color + "' " +
                "Price = " + String.valueOf(this.cost());
    }
}
