package ru.rukolf.pushsite.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.rukolf.pushsite.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //@GetMapping("/user/{id}")
    //todo: Create response entities first
}
