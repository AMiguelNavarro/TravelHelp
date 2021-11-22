package com.tfg.travelhelp.service.vaccine;

import com.tfg.travelhelp.domain.Vaccine;
import com.tfg.travelhelp.dto.IVaccineProjection;
import com.tfg.travelhelp.exceptions.VaccineNotFoundException;
import com.tfg.travelhelp.repository.IVaccineRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IVaccineServiceImp implements IVaccineService {

    @Autowired
    private IVaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> findAllVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<IVaccineProjection> findVaccinesFromCountry(long idCountry) {
        return vaccineRepository.findVaccinesFromCountry(idCountry);
    }

    @Override
    public Vaccine addNewVaccine(Vaccine newVaccine) {
        return vaccineRepository.save(newVaccine);
    }

    @Override
    public Vaccine modifyVaccine(long idOldVaccine, Vaccine newVaccine) {
        val vaccine = vaccineRepository.findById(idOldVaccine)
                .orElseThrow(() -> new VaccineNotFoundException(idOldVaccine));
        vaccine.setName(newVaccine.getName());
        vaccine.setDurability(newVaccine.getDurability());
        vaccine.setEffectivity(newVaccine.getEffectivity());
        return vaccineRepository.save(vaccine);
    }

    @Override
    public void deleteVaccine(long idOldVaccine) {
        val vaccine = vaccineRepository.findById(idOldVaccine)
                .orElseThrow(() -> new VaccineNotFoundException(idOldVaccine));
        vaccineRepository.delete(vaccine);
    }
}
