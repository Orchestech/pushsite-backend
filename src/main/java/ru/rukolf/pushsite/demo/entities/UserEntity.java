package ru.rukolf.pushsite.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<RoleEntity> roles;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,15}$")
    private String username;
    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$")
    private String password;
}
