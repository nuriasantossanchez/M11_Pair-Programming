package com.floristeria.project.view.frames;

/**
 * Exception que es lanzada cuando alguno de los datos de entrada
 * esta en blanco
 *
 */
class EmptyFieldException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmptyFieldException() {

    }

    public EmptyFieldException(String errorMessage) {

        super(errorMessage);
    }

}
