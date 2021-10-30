package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAll();
}
