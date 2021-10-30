package com.tfg.travelhelp.exceptions;

public class EmergencyPhoneNotFoundException extends RuntimeException{
    public EmergencyPhoneNotFoundException(){super();}
    public EmergencyPhoneNotFoundException(String message) {super(message);}
    public EmergencyPhoneNotFoundException(long id){super("Teléfono de emergencia no encontrado con ID -> " + id);}
}
