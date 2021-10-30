package com.tfg.travelhelp.exceptions;

public class LanguageNotFoundException extends RuntimeException{
    public LanguageNotFoundException(){super();}
    public LanguageNotFoundException(String message) {super(message);}
    public LanguageNotFoundException(long id){super("Idioma de emergencia no encontrado con ID -> " + id);}
}
