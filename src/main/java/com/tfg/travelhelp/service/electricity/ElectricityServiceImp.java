package com.tfg.travelhelp.service.electricity;

import com.tfg.travelhelp.domain.Electricity;
import com.tfg.travelhelp.exceptions.ElectricityNotFoundException;
import com.tfg.travelhelp.repository.IElectricityRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricityServiceImp implements IElectricityService{

    @Autowired
    IElectricityRepository electricityRepository;

    @Override
    public List<Electricity> findAllElectricities() {
        return electricityRepository.findAll();
    }

    @Override
    public Electricity addNewElectricity(Electricity newElectricity) {
        return electricityRepository.save(newElectricity);
    }

    @Override
    public Electricity modifyElectricity(long idOldElectricity, Electricity newElectricity) {
        val elec = electricityRepository.findById(idOldElectricity)
                .orElseThrow(() -> new ElectricityNotFoundException(idOldElectricity));
        newElectricity.setId(elec.getId());
        return electricityRepository.save(newElectricity);
    }

    @Override
    public void deleteElectricity(long idElectricity) {
        val elec = electricityRepository.findById(idElectricity)
                .orElseThrow(() -> new ElectricityNotFoundException(idElectricity));
        electricityRepository.delete(elec);
    }
}
