package com.tfg.travelhelp.service.plug;

import com.tfg.travelhelp.domain.Plug;
import com.tfg.travelhelp.exceptions.PlugNotFoundException;
import com.tfg.travelhelp.repository.IPlugRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPlugServiceImp implements IPlugService{

    @Autowired
    IPlugRepository plugRepository;

    @Override
    public List<Plug> findAllPlugs() {
        return plugRepository.findAll();
    }

    @Override
    public Plug findPlugsFromCountry(long idCountry) {
        return plugRepository.findPlugsFromCountry(idCountry);
    }

    @Override
    public Plug addNewPlug(Plug newPlug) {
        return plugRepository.save(newPlug);
    }

    @Override
    public Plug modifyPlug(long idOldPlug, Plug newPlug) {
        val plug = plugRepository.findById(idOldPlug)
                .orElseThrow(() -> new PlugNotFoundException(idOldPlug)); // Si no encuentra el enchufe por ID devuelve la excepción
        newPlug.setId(plug.getId());
        return plugRepository.save(newPlug);
    }

    @Override
    public void deletePlug(long idPlug) {
        val plug = plugRepository.findById(idPlug)
                .orElseThrow(() -> new PlugNotFoundException(idPlug));
        plugRepository.delete(plug);
    }
}
