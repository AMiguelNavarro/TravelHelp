package com.tfg.travelhelp.service.country;

import com.tfg.travelhelp.domain.Country;
import com.tfg.travelhelp.dto.CountryDTO;
import com.tfg.travelhelp.exceptions.CoinNotFoundException;
import com.tfg.travelhelp.exceptions.CountryNotFoundException;
import com.tfg.travelhelp.exceptions.ElectricityNotFoundException;
import com.tfg.travelhelp.repository.ICoinRepository;
import com.tfg.travelhelp.repository.ICountryRepository;
import com.tfg.travelhelp.repository.IElectricityRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImp implements ICountryService{

    @Autowired private ICountryRepository countryRepository;
    @Autowired private ICoinRepository coinRepository;
    @Autowired private IElectricityRepository electricityRepository;

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country addNewCountry(CountryDTO newCountryDto) {
        val coin = coinRepository.findById(newCountryDto.getIdCoin())
                .orElseThrow(() -> new CoinNotFoundException(newCountryDto.getIdCoin()));
        val elec = electricityRepository.findById(newCountryDto.getIdElectricity())
                .orElseThrow(() -> new ElectricityNotFoundException(newCountryDto.getIdElectricity()));

        Country newCountry = new Country();
        newCountry.setName(newCountryDto.getName());
        newCountry.setContinent(newCountryDto.getContinent());
        newCountry.setFlagImage(newCountryDto.getFlagImage());
        newCountry.setAcronym(newCountryDto.getAcronym());
        newCountry.setNumberOfHabitants(newCountryDto.getNumberOfHabitants());
        newCountry.setDrinkingWater(newCountry.isDrinkingWater());
        newCountry.setPublicHealthcare(newCountryDto.isPublicHealthcare());
        newCountry.setPrefix(newCountryDto.getPrefix());
        newCountry.setCoin(coin);
        newCountry.setElectricity(elec);

        return countryRepository.save(newCountry);
    }

    @Override
    public Country modifyCountry(long idOldCountry, CountryDTO newCountryDto) {
        val country = countryRepository.findById(idOldCountry)
                .orElseThrow(() -> new CountryNotFoundException(idOldCountry));
        val coin = coinRepository.findById(newCountryDto.getIdCoin())
                .orElseThrow(() -> new CoinNotFoundException(newCountryDto.getIdCoin()));
        val elec = electricityRepository.findById(newCountryDto.getIdElectricity())
                .orElseThrow(() -> new ElectricityNotFoundException(newCountryDto.getIdElectricity()));

        country.setName(newCountryDto.getName());
        country.setContinent(newCountryDto.getContinent());
        country.setFlagImage(newCountryDto.getFlagImage());
        country.setAcronym(newCountryDto.getAcronym());
        country.setNumberOfHabitants(newCountryDto.getNumberOfHabitants());
        country.setDrinkingWater(newCountryDto.isDrinkingWater());
        country.setPublicHealthcare(newCountryDto.isPublicHealthcare());
        country.setPrefix(newCountryDto.getPrefix());
        country.setCoin(coin);
        country.setElectricity(elec);

        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(long idCountry) {
        val country = countryRepository.findById(idCountry)
                .orElseThrow(() -> new CountryNotFoundException(idCountry));
        countryRepository.delete(country);
    }
}
