package com.tfg.travelhelp.service.languaje;

import com.tfg.travelhelp.domain.Language;
import com.tfg.travelhelp.dto.ILanguageProjection;

import java.util.List;

public interface ILanguageService {
    List<Language> findAllLanguages();
    List<ILanguageProjection> findLanguageFromCountry(long idCountry);
    Language addNewLanguage(Language newLanguage);
    Language modifyLanguage(long idOldLanguage, Language newLanguage);
    void deleteLanguage(long idOldLanguage);
}
