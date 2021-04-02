package com.floristeria.project.domain;

/**
 * Clase abstracta de la capa Domain
 *
 */
abstract class Price {

    public static final double PRICE_TREE = 25.00;
    public static final double PRICE_FLOWER = 2.50;
    public static final double PRICE_DECOR = 4.50;

    public abstract double cost();
}
