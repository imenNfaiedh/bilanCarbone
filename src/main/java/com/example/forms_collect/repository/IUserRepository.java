package com.example.forms_collect.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.forms_collect.entity.User;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
