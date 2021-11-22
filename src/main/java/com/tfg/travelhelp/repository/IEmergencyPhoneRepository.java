package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.EmergencyPhone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmergencyPhoneRepository extends CrudRepository<EmergencyPhone, Long> {
    List<EmergencyPhone> findAll();
    @Query(value = "SELECT * FROM emergency_phones WHERE emergency_phones.id_country = :idCountry", nativeQuery = true)
    List<EmergencyPhone> findEmergencyPhonesFromCountry(long idCountry);
}
