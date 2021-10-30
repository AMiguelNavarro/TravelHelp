package com.tfg.travelhelp.exceptions;

public class CoinNotFoundException extends RuntimeException{
    public CoinNotFoundException(){super();}
    public CoinNotFoundException(String message) {super(message);}
    public CoinNotFoundException(long id){super("Moneda no encontrada con ID -> " + id);}
}
