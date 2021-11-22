package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Vaccine;
import com.tfg.travelhelp.dto.IVaccineProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVaccineRepository extends CrudRepository<Vaccine, Long> {
    List<Vaccine> findAll();
    @Query(value = "select vaccines.durability, vaccines.effectivity, vaccine_countries.obligatory, vaccines.name from vaccine_countries INNER JOIN vaccines on vaccine_countries.id_vaccine = vaccines.id INNER JOIN countries on vaccine_countries.id_country = countries.id WHERE countries.id = :idCountry", nativeQuery = true)
    List<IVaccineProjection> findVaccinesFromCountry(long idCountry);
}
