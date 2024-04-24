package ru.rukolf.pushsite.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.rukolf.pushsite.demo.entities.UserEntity;
import ru.rukolf.pushsite.demo.repositories.UserRepository;
import ru.rukolf.pushsite.demo.responses.UserResponse;

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

    @GetMapping(value="/user/id{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserById(@PathVariable String id) throws JsonProcessingException {
        long userId = Long.parseLong(id);
        UserEntity userEntity = userRepository.findById(userId).orElse(new UserEntity());

        UserResponse userResponse = new UserResponse();
        userResponse.setName(userEntity.getName());
        userResponse.setSurname(userEntity.getSurname());
        userResponse.setPatronymic(userEntity.getPatronymic());
        userResponse.setUsername(userEntity.getUsername());

        List<String> roles = new ArrayList<>();
        userEntity.getRoles().forEach(role -> roles.add(role.getTitle()));

        userResponse.setRoles(roles);

        ObjectMapper objectMapper = new ObjectMapper();
        return ResponseEntity.ok(objectMapper.writeValueAsString(userResponse));
    }

    @GetMapping(value="/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserByUsername(@PathVariable String username) throws JsonProcessingException {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(new UserEntity());

        UserResponse userResponse = new UserResponse();
        userResponse.setName(userEntity.getName());
        userResponse.setSurname(userEntity.getSurname());
        userResponse.setPatronymic(userEntity.getPatronymic());
        userResponse.setUsername(userEntity.getUsername());
        
        List<String> roles = new ArrayList<>();
        userEntity.getRoles().forEach(role -> roles.add(role.getTitle()));

        userResponse.setRoles(roles);

        ObjectMapper objectMapper = new ObjectMapper();
        return ResponseEntity.ok(objectMapper.writeValueAsString(userResponse));
    }

    @GetMapping(value="/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> login(
        @RequestParam String username,
        @RequestParam String password) throws JsonProcessingException {

            UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

            ObjectMapper objectMapper = new ObjectMapper();

            if (userEntity == null)
            {
                return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(password);
            boolean isMatch = encoder.matches(userEntity.getPassword(), hashedPassword);

            if (!isMatch)
            {
                return new ResponseEntity<String>("Invalid password", HttpStatus.UNAUTHORIZED);
            }

            String token = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

            return ResponseEntity.ok(null);
        }
}
