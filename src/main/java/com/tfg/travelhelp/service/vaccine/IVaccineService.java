package com.tfg.travelhelp.service.vaccine;

import com.tfg.travelhelp.domain.Vaccine;

import java.util.List;

public interface IVaccineService {
    List<Vaccine> findAllVaccines();
    Vaccine addNewVaccine(Vaccine newVaccine);
    Vaccine modifyVaccine(long idOldVaccine, Vaccine newVaccine);
    void delteVaccine(long idOldVaccine);
}
