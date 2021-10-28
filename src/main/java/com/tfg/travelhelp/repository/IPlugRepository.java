package com.tfg.travelhelp.repository;


import com.tfg.travelhelp.domain.Plug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlugRepository extends CrudRepository<Plug, Long> {
    List<Plug> findAll(); // Se sobreescribe para que no devuelva un iterable
}
