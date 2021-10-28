package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Electricity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElectricityRepository extends CrudRepository<Electricity, Long> {
    List<Electricity> findAll();
}
