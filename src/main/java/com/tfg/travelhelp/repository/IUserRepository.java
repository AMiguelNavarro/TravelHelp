package com.tfg.travelhelp.repository;

import com.tfg.travelhelp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
}
