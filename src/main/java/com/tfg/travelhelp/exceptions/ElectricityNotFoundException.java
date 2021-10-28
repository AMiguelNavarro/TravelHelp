package com.tfg.travelhelp.exceptions;

public class ElectricityNotFoundException extends RuntimeException{
    public ElectricityNotFoundException(){super();}
    public ElectricityNotFoundException(String message) {super(message);}
    public ElectricityNotFoundException(long id){super("Electricidad no encontrado con ID -> " + id);}
}
