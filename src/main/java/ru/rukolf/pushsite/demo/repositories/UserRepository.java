package ru.rukolf.pushsite.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.rukolf.pushsite.demo.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional<UserEntity> findUserById(Long id);
    Optional<UserEntity> findUserByUsername(String username);
    Optional<List<UserEntity>> findAllByRole(String role);

}
