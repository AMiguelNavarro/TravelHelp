package com.tfg.travelhelp.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(){super();}
    public CountryNotFoundException(String message) {super(message);}
    public CountryNotFoundException(long id){super("Pais no encontrado con ID -> " + id);}
}
