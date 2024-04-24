package ru.rukolf.pushsite.demo.responses;

import java.util.List;

import lombok.Data;

@Data
public class User {

    private String name;
    private String surname;
    private String patronymic;
    private String username;

    private List<String> roles;

}