package ru.rukolf.pushsite.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.rukolf.pushsite.demo.entities.UserEntity;
import ru.rukolf.pushsite.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserRepository getUserRepository()
    {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping(value="/user/{id}")
    ResponseEntity<?> getUserById(@PathVariable String id) throws JsonProcessingException {
        long userId = Long.parseLong(id);
        UserEntity userEntity = userRepository.findById(userId).orElse(new UserEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        return ResponseEntity.ok(objectMapper.writeValueAsString(userEntity));
    }
}
