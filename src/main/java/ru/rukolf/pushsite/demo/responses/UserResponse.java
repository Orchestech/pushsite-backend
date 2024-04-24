package ru.rukolf.pushsite.demo.responses;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {

    public String name;
    public String surname;
    public String patronymic;
    public String username;

    public List<String> roles;

}