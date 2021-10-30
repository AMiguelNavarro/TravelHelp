package com.tfg.travelhelp.service.city;

import com.tfg.travelhelp.domain.City;
import com.tfg.travelhelp.dto.CityDTO;
import com.tfg.travelhelp.exceptions.CityNotFoundException;
import com.tfg.travelhelp.exceptions.CountryNotFoundException;
import com.tfg.travelhelp.repository.ICityRepository;
import com.tfg.travelhelp.repository.ICountryRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements ICityService{

    @Autowired
    ICityRepository cityRepository;

    @Autowired
    ICountryRepository countryRepository;


    @Override
    public List<City> finAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addNewCity(CityDTO newCityDto) {
        val countrySelected = countryRepository.findById(newCityDto.getIdCountry())
                .orElseThrow(() -> new CountryNotFoundException(newCityDto.getIdCountry()));

        City city = new City();
        city.setName(newCityDto.getName());
        city.setExtension(newCityDto.getExtension());
        city.setNumberOfHabitants(newCityDto.getNumberOfHabitants());
        city.setCountry(countrySelected);

        return cityRepository.save(city);
    }

    @Override
    public City modifyCity(long idCity, CityDTO newCityDto) {
        val city = cityRepository.findById(idCity)
                .orElseThrow(() -> new CityNotFoundException(idCity));

        val country = countryRepository.findById(newCityDto.getIdCountry())
                .orElseThrow(() -> new CountryNotFoundException(newCityDto.getIdCountry()));

        city.setName(newCityDto.getName());
        city.setExtension(newCityDto.getExtension());
        city.setNumberOfHabitants(newCityDto.getNumberOfHabitants());
        city.setCountry(country);

        return cityRepository.save(city);
    }


    @Override
    public void deleteCity(long idCity) {
        val city = cityRepository.findById(idCity)
                .orElseThrow(() -> new CityNotFoundException(idCity));
        cityRepository.delete(city);
    }
}
