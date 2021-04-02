package com.floristeria.project.persistence;

import com.floristeria.project.domain.Florist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase de la capa Persistence
 *
 * Implementa el patron Singleton
 *
 */
public class Repository {

    private static Repository instance=null;
    private static List<Florist> florists = new ArrayList<>();

    /**
     * Constructor privado de la clase Controller (patron Singleton)
     */
    private Repository(){

    }

    /**
     * Metodo que retorna una instancia unica de la clase Repository
     * y representa el punto global de acceso al Repository
     *
     * @return instacia unica de la clase Repository
     */
    public static Repository getInstance(){
        if (instance==null){
            instance=new Repository();
        }
        return instance;

    }

    public void addFlorist(Florist florist) throws Exception {
        if (florist == null) {
            throw new Exception();
        }
        florists.add(florist);
    }

    public List<Florist> getAllFlorists() {

        return new ArrayList<>(florists);
    }

    public Optional<Florist> findFlorist(String name){
        return getAllFlorists().stream().filter(f-> f.getName().equalsIgnoreCase(name)).findFirst();
    }

    public boolean existFlorist(String name) {
        return getAllFlorists().stream().anyMatch(f -> f.getName().equalsIgnoreCase(name));
    }

}

