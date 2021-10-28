package com.tfg.travelhelp.service.electricity;


import com.tfg.travelhelp.domain.Electricity;

import java.util.List;

public interface IElectricityService {
    List<Electricity> findAllElectricities();
    Electricity addNewElectricity(Electricity newElectricity);
    Electricity modifyElectricity(long idOldElectricity, Electricity newElectricity);
    void deleteElectricity(long idElectricity);
}
