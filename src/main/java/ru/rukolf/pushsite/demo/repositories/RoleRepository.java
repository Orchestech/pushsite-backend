package ru.rukolf.pushsite.demo.repositories;
import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.rukolf.pushsite.demo.entities.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    
    Optional<RoleEntity> findById(Long id);
    Optional<RoleEntity> findByTitle(String title);
    List<RoleEntity> findAllByOperator(Boolean operator);
    List<RoleEntity> findAll();

}
