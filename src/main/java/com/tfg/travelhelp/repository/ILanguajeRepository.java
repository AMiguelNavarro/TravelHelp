package com.tfg.travelhelp.repository;


import com.tfg.travelhelp.domain.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguajeRepository extends CrudRepository<Language, Long> {
}
