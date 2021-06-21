package com.kf.example.usecase;

import com.kf.example.domain.entity.User;
import com.kf.example.usecase.ports.UserRepository;

import java.util.List;
import java.util.Optional;

public class FindUser {

    private final UserRepository repository;

    public FindUser(final UserRepository repo) {
        this.repository = repo;
    }

    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

}
