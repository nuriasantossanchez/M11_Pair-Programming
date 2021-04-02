package com.floristeria.project.domain;

/**
 * Clase de la capa Domain
 *
 */
public class Decor extends Price{

    String type;

    public Decor(String type) {
        this.type=type;
    }

    @Override
    public double cost() {
        double cost  = DecorTypeEnum.PLASTIC.getType().equalsIgnoreCase(this.type) ?
                DecorTypeEnum.PLASTIC.getCost() : DecorTypeEnum.WOOD.getCost();
        return PRICE_DECOR+cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\tDecor Type = '" + type + "' " +
                "Price = " + String.valueOf(this.cost());
    }
}
