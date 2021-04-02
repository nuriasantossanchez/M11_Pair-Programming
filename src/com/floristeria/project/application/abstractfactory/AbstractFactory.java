package com.floristeria.project.application.abstractfactory;

import com.floristeria.project.domain.*;

/**
 * Interfaz de la clase Application
 *
 * Se utiliza para implementar el patron AbstractFactory con el fin
 * de desacoplar la creacion de objetos
 */
public interface AbstractFactory {
    Florist createFlorist(String name);
    Tree createTree(double height);
    Flower createFlower(String color);
    Decor createDecor(String decorType);
}
