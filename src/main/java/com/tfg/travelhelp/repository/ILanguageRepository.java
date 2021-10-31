package com.tfg.travelhelp.repository;


import com.tfg.travelhelp.domain.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
}
