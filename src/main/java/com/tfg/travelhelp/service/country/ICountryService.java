package com.tfg.travelhelp.service.country;

import com.tfg.travelhelp.domain.Country;
import com.tfg.travelhelp.dto.CountryDTO;

import java.util.List;

public interface ICountryService {
    List<Country> findAllCountries();
    Country addNewCountry(CountryDTO newCountryDto);
    Country modifyCountry(long idOldCountry, CountryDTO newCountryDto);
    void deleteCountry(long idCountry);
}
