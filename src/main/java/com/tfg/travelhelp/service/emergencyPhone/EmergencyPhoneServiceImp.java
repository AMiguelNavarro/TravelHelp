package com.tfg.travelhelp.service.emergencyPhone;

import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.dto.EmergencyPhoneDTO;
import com.tfg.travelhelp.exceptions.CountryNotFoundException;
import com.tfg.travelhelp.exceptions.EmergencyPhoneNotFoundException;
import com.tfg.travelhelp.repository.ICountryRepository;
import com.tfg.travelhelp.repository.IEmergencyPhoneRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyPhoneServiceImp implements IEmergencyPhoneService {

    @Autowired
    private IEmergencyPhoneRepository emergencyPhoneRepository;

    @Autowired
    private ICountryRepository countryRepository;


    @Override
    public List<EmergencyPhone> findAllEmergencyPhones() {
        return emergencyPhoneRepository.findAll();
    }

    @Override
    public List<EmergencyPhone> findEmergencyPhonesFromCountry(long idCountry) {
        return emergencyPhoneRepository.findEmergencyPhonesFromCountry(idCountry);
    }

    @Override
    public EmergencyPhone addNewEmergencyPhone(EmergencyPhoneDTO newEmergencyPhoneDto) {
        val country = countryRepository.findById(newEmergencyPhoneDto.getIdCountry())
                .orElseThrow(() -> new CountryNotFoundException(newEmergencyPhoneDto.getIdCountry()));

        EmergencyPhone emergencyPhone = new EmergencyPhone();
        emergencyPhone.setCountry(country);
        emergencyPhone.setPhoneNumber(newEmergencyPhoneDto.getPhoneNumber());
        emergencyPhone.setService(newEmergencyPhoneDto.getService());

        return emergencyPhoneRepository.save(emergencyPhone);
    }

    @Override
    public EmergencyPhone modifyEmergencyPhone(long idOldEmergencyPhone, EmergencyPhoneDTO newEmergencyPhoneDto) {
        val emergencyPhone = emergencyPhoneRepository.findById(idOldEmergencyPhone)
                .orElseThrow(() -> new EmergencyPhoneNotFoundException(idOldEmergencyPhone));
        val country = countryRepository.findById(newEmergencyPhoneDto.getIdCountry())
                .orElseThrow(() -> new CountryNotFoundException(newEmergencyPhoneDto.getIdCountry()));

        emergencyPhone.setCountry(country);
        emergencyPhone.setPhoneNumber(newEmergencyPhoneDto.getPhoneNumber());
        emergencyPhone.setService(newEmergencyPhoneDto.getService());

        return emergencyPhoneRepository.save(emergencyPhone);
    }

    @Override
    public void deleteEmergencyPhone(long idEmergencyPhone) {
        val emergencyPhone = emergencyPhoneRepository.findById(idEmergencyPhone)
                .orElseThrow(() -> new EmergencyPhoneNotFoundException(idEmergencyPhone));
        emergencyPhoneRepository.delete(emergencyPhone);
    }
}
