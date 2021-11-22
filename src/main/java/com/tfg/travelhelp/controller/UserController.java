package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.User;
import com.tfg.travelhelp.service.user.IUserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user/{username}/{password}", produces = "application/json")
    public ResponseEntity<User> checkUserNameAndPassword(@PathVariable String username, @PathVariable String password) {
        val userCheck = userService.checkUserLogin(username,password);
        return new ResponseEntity<>(userCheck, HttpStatus.OK);
    }

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        val newUser = userService.addNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
