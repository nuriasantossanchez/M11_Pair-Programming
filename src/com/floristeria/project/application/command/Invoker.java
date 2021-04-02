package com.floristeria.project.application.command;

import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.Florist;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;

/**
 *  Clase de la capa Application, se utiliza para implementar el patron ICommand
 *
 *  Realiza la solicitud de peticiones, haciendo uso de la interface comun ICommand,
 *  a traves de la cual se pueden ejecutar distintas solicitudes.
 *
 */

public class Invoker {
    private ICommand ICommand;

    /**
     * Constructor de la clase, compuesto por una interface de tipo ICommand,
     * pasada como parametro, que encapsula las distintas peticiones
     *
     * @param ICommand, interfaz de tipo ICommand
     */
    public Invoker(ICommand ICommand) {

        this.ICommand = ICommand;
    }

    public Florist createFlorist(String name) {

        return ICommand.createFlorist(name);
    }

    public Tree createTree(double high) {
        return ICommand.createTree(high);
    }

    public Flower createFlower(String color) {
        return ICommand.createFlower(color);
    }


    public Decor createDecor(String type) {
        return ICommand.createDecor(type);
    }


    public void addTree(Florist florist, Tree tree) {

        ICommand.addTree(florist,tree);
    }


    public void addFlower(Florist florist, Flower flower){

        ICommand.addFlower(florist, flower);
    }

    public void addDecor(Florist florist, Decor decor){

        ICommand.addDecor(florist, decor);
    }

    public void printStock(Florist florist) {

        ICommand.printStock(florist);
    }
}
