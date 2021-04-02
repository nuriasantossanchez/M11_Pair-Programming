package com.floristeria.project.domain;

/**
 * Clase de la capa Domain
 *
 */
public class Tree extends Price{

    public double height;

    public Tree(double height) {
        this.height = height;
    }

    @Override
    public double cost() {
        return PRICE_TREE + height*2.50;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "\tHeight = " + height + "' " +
                "Price = " + String.valueOf(this.cost());
    }
}
