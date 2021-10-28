package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepository extends CrudRepository<Vaccine, Long> {
}
