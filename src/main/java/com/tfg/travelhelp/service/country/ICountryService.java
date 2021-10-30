package com.tfg.travelhelp.service.country;

import com.tfg.travelhelp.domain.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAllCountries();
    Country addNewCountry(Country newCountry);
    Country modifyCountry(long idOldCountry, Country newCountry);
    void deleteCountry(long idCountry);
}
