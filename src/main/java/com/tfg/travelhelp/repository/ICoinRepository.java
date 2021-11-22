package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Coin;
import com.tfg.travelhelp.domain.EmergencyPhone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAll();
    @Query(value = "SELECT coins.id, coins.iso_code, coins.monetary_unit, coins.symbol FROM coins INNER JOIN countries on coins.id = countries.id_coin WHERE countries.id = :idCountry", nativeQuery = true)
    Coin findCoinFromCountry(long idCountry);
}
