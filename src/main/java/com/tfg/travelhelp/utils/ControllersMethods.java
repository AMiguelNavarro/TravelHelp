package com.tfg.travelhelp.utils;


import org.springframework.http.ResponseEntity;
import java.util.List;

// Interfaz genérica que implementan los controller con los métodos principales
public interface ControllersMethods<T> {
    ResponseEntity<List<T>>getAll();
    ResponseEntity<T>addNew(T newObject);
    ResponseEntity<T>modify(long id, T newObject);
    ResponseEntity<Response>delete(long id);
}
