package com.tfg.travelhelp.exceptions;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(){super();}
    public CityNotFoundException(String message) {super(message);}
    public CityNotFoundException(long id){super("Ciudad no encontrada con ID -> " + id);}
}
