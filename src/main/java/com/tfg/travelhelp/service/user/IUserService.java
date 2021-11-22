package com.tfg.travelhelp.service.user;

import com.tfg.travelhelp.domain.User;

public interface IUserService {
    User addNewUser(User newUser);
    User checkUserLogin(String username, String password);
}
