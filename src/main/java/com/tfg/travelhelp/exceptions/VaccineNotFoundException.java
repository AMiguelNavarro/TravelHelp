package com.tfg.travelhelp.exceptions;

public class VaccineNotFoundException extends RuntimeException{
    public VaccineNotFoundException(){super();}
    public VaccineNotFoundException(String message) {super(message);}
    public VaccineNotFoundException(long id){super("Vacuna no encontrada con ID -> " + id);}
}
