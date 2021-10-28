package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.EmergencyPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmergencyPhoneRepository extends CrudRepository<EmergencyPhone, Long> {
}
