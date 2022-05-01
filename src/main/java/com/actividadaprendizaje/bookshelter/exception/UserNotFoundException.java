package com.actividadaprendizaje.bookshelter.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("Usuario no encontrado");
    }
}
