package com.tfg.travelhelp.utils;


import org.springframework.http.ResponseEntity;

import java.util.List;

// Interfaz genérica que implementan los controller con los métodos principales
public interface ControllersMethodsDTO<T, Y> {
    ResponseEntity<List<T>>getAll();
    ResponseEntity<T>addNew(Y newObject);
    ResponseEntity<T>modify(long id, Y newObject);
    ResponseEntity<Response>delete(long id);
}
