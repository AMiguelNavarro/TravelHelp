package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Electricity;
import com.tfg.travelhelp.domain.Plug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElectricityRepository extends CrudRepository<Electricity, Long> {
    List<Electricity> findAll();
    @Query(value = "SELECT electricities.id, electricities.frecuency, electricities.voltage FROM electricities INNER JOIN countries on countries.id_electricity = electricities.id where countries.id = :idCountry", nativeQuery = true)
    Electricity findElectricityFromCountry(long idCountry);
}
