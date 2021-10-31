package com.tfg.travelhelp.service.emergencyPhone;

import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.dto.EmergencyPhoneDTO;

import java.util.List;

public interface IEmergencyPhoneService {
    List<EmergencyPhone> findAllEmergencyPhones();
    EmergencyPhone addNewEmergencyPhone(EmergencyPhoneDTO newEmergencyPhoneDto);
    EmergencyPhone modifyEmergencyPhone(long idOldEmergencyPhone, EmergencyPhoneDTO newEmergencyPhoneDto);
    void deleteEmergencyPhone(long idEmergencyPhone);
}
