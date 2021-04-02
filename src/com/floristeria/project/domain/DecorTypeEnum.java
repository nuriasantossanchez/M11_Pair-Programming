package com.floristeria.project.domain;

/**
 * Enum de la capa Domain
 *
 */
public enum DecorTypeEnum {

    PLASTIC("PLASTIC", 9.90), WOOD("WOOD",15.60);

    private String type;
    private double cost;

    DecorTypeEnum(String type, double cost) {
        this.type=type;
        this.cost=cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
