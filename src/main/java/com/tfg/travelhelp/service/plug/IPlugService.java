package com.tfg.travelhelp.service.plug;

import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.domain.Plug;

import java.util.List;

public interface IPlugService {
    List<Plug> findAllPlugs();
    Plug findPlugsFromCountry(long idCountry);
    Plug addNewPlug(Plug newPlug);
    Plug modifyPlug(long idOldPlug, Plug newPlug);
    void deletePlug(long idPlug);
}
