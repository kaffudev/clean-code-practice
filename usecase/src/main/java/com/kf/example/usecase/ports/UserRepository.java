package com.kf.example.usecase.ports;

import com.kf.example.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User create(User user);
    List<User> findAllUsers();
    Optional<User> findById(String id);
    Optional<User> findUserByEmail(String email);
}
