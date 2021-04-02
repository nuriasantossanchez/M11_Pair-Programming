package com.floristeria.project.application.abstractfactory;

import com.floristeria.project.domain.*;

/**
 * Clase de la clase Application
 *
 * Se utiliza para implementar el patron AbstractFactory
 *
 * Implementa la interfaz AbstractFactory en cuyos metodos queda
 * desacoplada la creacion de objetos
 *
 */
public class Factory implements AbstractFactory{

    @Override
    public Florist createFlorist(String name) {
        Florist florist =new Florist(name);
        return florist;
    }

    @Override
    public Tree createTree(double height) {
        Tree tree = new Tree(height);
        return tree;
    }

    @Override
    public Flower createFlower(String color) {
        Flower flower =new Flower(color);
        return flower;
    }

    @Override
    public Decor createDecor(String decorType) {
        Decor decor= new Decor(decorType);
        return decor;
    }


}
