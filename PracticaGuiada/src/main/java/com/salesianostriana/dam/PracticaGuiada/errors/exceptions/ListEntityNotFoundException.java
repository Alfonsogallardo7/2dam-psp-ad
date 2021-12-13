package com.salesianostriana.dam.PracticaGuiada.errors.exceptions;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se puede encontrar elementos del tipo %s ", clazz.getName()));
    }
}
