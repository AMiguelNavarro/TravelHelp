package com.tfg.travelhelp.service.city;

import com.tfg.travelhelp.domain.City;
import com.tfg.travelhelp.dto.CityDTO;
import java.util.List;

public interface ICityService {
    List<City> finAllCities();
    City addNewCity(CityDTO newCityDto);
    City modifyCity(long idCity, CityDTO newCityDto);
    void deleteCity(long idCity);
}
