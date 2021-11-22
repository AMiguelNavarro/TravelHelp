package com.tfg.travelhelp.service.vaccine;

import com.tfg.travelhelp.domain.Vaccine;
import com.tfg.travelhelp.dto.IVaccineProjection;

import java.util.List;

public interface IVaccineService {
    List<Vaccine> findAllVaccines();
    List<IVaccineProjection> findVaccinesFromCountry(long idCountry);
    Vaccine addNewVaccine(Vaccine newVaccine);
    Vaccine modifyVaccine(long idOldVaccine, Vaccine newVaccine);
    void deleteVaccine(long idOldVaccine);
}
