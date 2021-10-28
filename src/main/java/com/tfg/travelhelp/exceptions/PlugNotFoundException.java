package com.tfg.travelhelp.exceptions;

public class PlugNotFoundException extends RuntimeException{
    public PlugNotFoundException(){super();}
    public PlugNotFoundException(String message) {super(message);}
    public PlugNotFoundException(long id){super("Enchufe no encontrado con ID -> " + id);}
}
