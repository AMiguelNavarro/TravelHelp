package com.tfg.travelhelp.repository;


import com.tfg.travelhelp.domain.Language;
import com.tfg.travelhelp.dto.ILanguageProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
    // Solucionado aqui https://stackoverflow.com/questions/15948795/is-it-possible-to-use-raw-sql-within-a-spring-repository/50365522#50365522
    @Query(value = "SELECT languages.name, languages_countries.official from languages INNER JOIN languages_countries on languages.id = languages_countries.id_language INNER JOIN countries on countries.id = languages_countries.id_country WHERE id_country = :idCountry", nativeQuery = true)
    List<ILanguageProjection> findLanguageFromCountry(long idCountry);
}
