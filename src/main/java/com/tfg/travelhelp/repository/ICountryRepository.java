package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
}
