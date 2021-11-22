package com.tfg.travelhelp.service.user;

import com.tfg.travelhelp.domain.User;
import com.tfg.travelhelp.exceptions.UserNotFoundException;
import com.tfg.travelhelp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public User addNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User checkUserLogin(String username, String password) {
        User user = userRepository.findByUserNameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("No se encuentra el usuario"));

        return user;
    }
}
