package com.floristeria.project.application.command;

import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.Florist;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;

/**
 * Interface de la capa Application, se utiliza para implementar el patron ICommand
 *
 * Encapsula ciertas peticiones en un objeto con el fin de desacoplar
 * el objeto que solicita una peticion, de la peticon en si
 *
 * Expone los metodos que han de ser implementados por la clase Command,
 * clase que implementa la interface ICommand
 *
 */
public interface ICommand {
    Florist createFlorist(String name);

    Tree createTree(double high);

    Flower createFlower(String color);

    Decor createDecor(String type);

    void addTree(Florist florist, Tree tree);

    void addFlower(Florist florist, Flower flower);

    void addDecor(Florist florist, Decor decor);

    void printStock(Florist florist);

}
