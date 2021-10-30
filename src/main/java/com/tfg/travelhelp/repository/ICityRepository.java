package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
