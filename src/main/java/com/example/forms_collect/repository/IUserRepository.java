package com.example.forms_collect.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.forms_collect.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
