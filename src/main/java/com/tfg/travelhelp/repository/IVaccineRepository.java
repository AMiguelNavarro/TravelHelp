package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVaccineRepository extends CrudRepository<Vaccine, Long> {
    List<Vaccine> findAll();
}
