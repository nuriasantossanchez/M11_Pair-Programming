package com.floristeria.project.application.command;

import com.floristeria.project.application.abstractfactory.AbstractFactory;
import com.floristeria.project.application.abstractfactory.Factory;
import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.Florist;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;

import java.util.Locale;

/**
 *  Clase de la capa Application, se utiliza para implementar el patron ICommand
 *
 *  Se encarga de realizar las peticiones solicitadas
 *
 *  Hace uso del patron AbstractFactory para la creacion de objetos de la capa de Dominio
 *
 */
public class Receiver {

    private AbstractFactory factory;

    /**
     * Constructor
     * Inicializa la clase Factory que implementa el patron AbstractFactory
     * @param factory
     */
    public Receiver(AbstractFactory factory){
        this.factory= new Factory();

    }

    public Florist createFlorist(String name) {
        return factory.createFlorist(name);
    }

    public Tree createTree(double high) {
        return factory.createTree(high);
    }

    public Flower createFlower(String color) {
        return factory.createFlower(color);
    }

    public Decor createDecor(String type) {
        return factory.createDecor(type);
    }


    public void addTree(Florist florist, Tree tree) {

        florist.addTree(tree);
    }

    public void addFlower(Florist florist, Flower flower) {
        florist.addFlower(flower);
    }

    public void addDecor(Florist florist, Decor decor) {
        florist.addDecor(decor);
    }

    public void printStock(Florist florist) {
        System.out.println(florist.getName().toUpperCase(Locale.ROOT));
        System.out.println("Trees:");

        if ((florist.getTrees().size() != 0)) {
            florist.getTrees().stream().forEach(System.out::println);
        } else {
            System.out.println("\tNo Trees");
        }

        System.out.println("Flowers:");
        if ((florist.getFlowers().size() != 0)) {
            florist.getFlowers().stream().forEach(System.out::println);
        } else {
            System.out.println("\tNo Flowers");
        }

        System.out.println("Decors:");
        if ((florist.getDecors().size() != 0)) {
            florist.getDecors().stream().forEach(System.out::println);
        } else {
            System.out.println("\tNo Decors");
        }
    }

}
