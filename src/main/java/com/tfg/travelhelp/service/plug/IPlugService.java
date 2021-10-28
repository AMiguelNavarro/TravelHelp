package com.tfg.travelhelp.service.plug;

import com.tfg.travelhelp.domain.Plug;

import java.util.List;

public interface IPlugService {
    List<Plug> findAllPlugs();
    Plug addNewPlug(Plug newPlug);
    Plug modifyPlug(long idOldPlug, Plug newPlug);
    void deletePlug(long idPlug);
}
