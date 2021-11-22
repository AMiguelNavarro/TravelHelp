package com.tfg.travelhelp.repository;


import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.domain.Plug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlugRepository extends CrudRepository<Plug, Long> {
    List<Plug> findAll(); // Se sobreescribe para que no devuelva un iterable
    @Query(value = "select plugs.type, plugs.image, plugs.id from plugs INNER JOIN countries_plugs on plugs.id = countries_plugs.id_plug INNER JOIN countries on countries.id = countries_plugs.id_country WHERE id_country = :idCountry", nativeQuery = true)
    Plug findPlugsFromCountry(long idCountry);
}
