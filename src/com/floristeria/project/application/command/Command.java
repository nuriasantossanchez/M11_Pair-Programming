package com.floristeria.project.application.command;

import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.Florist;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;

/**
 *  Clase de la capa Application, se utiliza para implementar el patron ICommand
 *
 *  Esta clase implementa la interfaz ICommand por lo que esta obligada a implementar los metodos
 *  que expone la interfaz
 *
 *  La interfaz ICommand encapsula las distintas peticiones, la implementacion de
 *  estas peticiones permiten ejecutar una solicitud
 *
 */
public class Command implements ICommand {

    private Receiver receiver;

    /**
     * Constructor de la clase, compuesto por un objeto de tipo Receiver, pasado como parametro,
     * encargado de ejecutar las distintas acciones
     *
     * @param receiver, objeto de tipo Receiver que realiza las acciones solicitadas
     */
    public Command(Receiver receiver) {

        this.receiver = receiver;
    }

    @Override
    public Florist createFlorist(String name) {

        return receiver.createFlorist(name);
    }

    @Override
    public Tree createTree(double high) {
        return receiver.createTree(high);
    }

    @Override
    public Flower createFlower(String color) {
        return receiver.createFlower(color);
    }

    @Override
    public Decor createDecor(String type) {
        return receiver.createDecor(type);
    }

    @Override
    public void addTree(Florist florist, Tree tree) {
        receiver.addTree(florist, tree);

    }

    @Override
    public void addFlower(Florist florist, Flower flower) {
        receiver.addFlower(florist, flower);
    }

    @Override
    public void addDecor(Florist florist, Decor decor) {
        receiver.addDecor(florist, decor);
    }

    @Override
    public void printStock(Florist florist) {
        receiver.printStock(florist);
    }

}
