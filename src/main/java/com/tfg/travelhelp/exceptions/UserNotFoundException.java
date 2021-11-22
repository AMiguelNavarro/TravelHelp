package com.tfg.travelhelp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super();}
    public UserNotFoundException(String message) {super(message);}
    public UserNotFoundException(long id){super("Usuario no encontrada con ID -> " + id);}
}
