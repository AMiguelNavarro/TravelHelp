package com.tfg.travelhelp.service.languaje;

import com.tfg.travelhelp.domain.Language;
import com.tfg.travelhelp.dto.ILanguageProjection;
import com.tfg.travelhelp.exceptions.LanguageNotFoundException;
import com.tfg.travelhelp.repository.ILanguageRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImp implements ILanguageService {

    @Autowired
    private ILanguageRepository languageRepository;

    @Override
    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public List<ILanguageProjection> findLanguageFromCountry(long idCountry) {
        return languageRepository.findLanguageFromCountry(idCountry);
    }

    @Override
    public Language addNewLanguage(Language newLanguage) {
        return languageRepository.save(newLanguage);
    }

    @Override
    public Language modifyLanguage(long idOldLanguage, Language newLanguage) {
        val language = languageRepository.findById(idOldLanguage)
                .orElseThrow(() -> new LanguageNotFoundException(idOldLanguage));
        language.setName(newLanguage.getName());
        return languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(long idOldLanguage) {
        val language = languageRepository.findById(idOldLanguage)
                .orElseThrow(() -> new LanguageNotFoundException(idOldLanguage));
        languageRepository.delete(language);
    }
}
