package com.floristeria.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la capa Domain
 *
 */
public class Florist {

    private String name;
    private List<Tree> trees =new ArrayList<Tree>();
    private List<Flower> flowers =new ArrayList<Flower>();
    private List<Decor> decors =new ArrayList<Decor>();

    public Florist(String name) {
        this.name=name;
    }

    public void addTree(Tree tree) {
        this.trees.add(tree);
    }

    public void addFlower(Flower flower) {
        this.flowers.add(flower);
    }

    public void addDecor(Decor decor) {
        this.decors.add(decor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Decor> getDecors() {
        return decors;
    }

    public void setDecors(List<Decor> decors) {
        this.decors = decors;
    }

    @Override
    public String toString() {
        return "Florist{" +
                "name='" + name + '\'' +
                ", trees=" + trees +
                ", flowers=" + flowers +
                ", decors=" + decors +
                '}';
    }
}
