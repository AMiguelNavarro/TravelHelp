package com.tfg.travelhelp.service.emergencyPhone;

import com.tfg.travelhelp.domain.EmergencyPhone;

import java.util.List;

public interface IEmergencyPhoneService {
    List<EmergencyPhone> findAllEmergencyPhones();
    EmergencyPhone addNewEmergencyPhone(EmergencyPhone newEmergencyPhone);
    EmergencyPhone modifyEmergencyPhone(long idOldEmergencyPhone, EmergencyPhone newEmergencyPhone);
    void deleteEmergencyPhone(long idEmergencyPhone);
}
