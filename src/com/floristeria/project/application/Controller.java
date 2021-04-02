package com.floristeria.project.application;

import com.floristeria.project.application.abstractfactory.Factory;
import com.floristeria.project.application.command.Command;
import com.floristeria.project.application.command.Invoker;
import com.floristeria.project.application.command.Receiver;
import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.Florist;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;
import com.floristeria.project.persistence.Repository;

import java.util.List;

/**
 * Clase de la capa Application
 *
 * Implementa el patron Singleton
 * Hace uso del patron ICommand para ejecutar solicitudes de peticiones
 *
 */
public class Controller {

    private Repository repository;
    private Florist florist;
    private Tree tree;
    private Flower flower;
    private Decor decor;
    private Invoker invoker;
    private static Controller instance=null;


    /**
     * Constructor privado de la clase Controller
     *
     * Inicializa la clase Repository que alamcena la informacion de usuarios creados
     * y sus videos asociados
     *
     *
     * Inicializa la clase Invoker, que se utiliza para implemetar el patron ICommand
     *
     * El constructor privado asegura que la clase solo tendra una instancia (patron Singleton)
     * La clase Controller proveera un punto global de acceso
     */
    private Controller() {
        this.repository = Repository.getInstance();
        this.invoker = new Invoker(new Command(new Receiver(new Factory())));

    }

    /**
     * Metodo que representa el punto global de acceso a la instancia unica
     * de la clase Controller
     *
     * @return instacia unica de la clase Controller
     */
    public static Controller getInstance(){
        if (instance==null){
            instance=new Controller();
        }
        return instance;

    }

    public Florist createFlorist(String name) throws Exception {
        florist=repository.findFlorist(name).orElse(invoker.createFlorist(name));
        if (!repository.existFlorist(florist.getName())){
            repository.addFlorist(florist);
        }
        return florist;

    }

    public Florist findFlorist(String name){
        florist = repository.findFlorist(name).get();
        return florist;
    }

    public List<Florist> getAllFlorists() {
        List<Florist> allFlorists = repository.getAllFlorists();
        //allFlorists.stream().forEach(System.out::println);
        //System.out.println("-----------------------------------");
        return allFlorists;
    }

    public Tree createTree(double high){
        tree = invoker.createTree(high);
        addTree(tree, florist);
        return tree;
    }

    public Flower createFlower(String color) {
        flower = invoker.createFlower(color);
        addFlower(flower,florist);
        return flower;
    }

    public Decor createDecor(String type){
        decor = invoker.createDecor(type);
        addDecor(decor,florist);
        return decor;
    }

    public void addTree(Tree tree, Florist florist){

        invoker.addTree(florist, tree);
    }

    public void addFlower(Flower flower, Florist florist){

        invoker.addFlower(florist, flower);
    }


    public void addDecor(Decor decor, Florist florist){

        invoker.addDecor(florist, decor);
    }

    public void printStock(Florist florist){
        invoker.printStock(florist);
   }

    public Florist getFlorist() {
        return florist;
    }
}
