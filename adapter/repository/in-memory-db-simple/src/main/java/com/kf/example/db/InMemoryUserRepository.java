package com.kf.example.db;

import com.kf.example.domain.entity.User;
import com.kf.example.usecase.ports.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    Map<String, User> inMemoryDb = new HashMap<>();

    @Override
    public User create(User user) {
        inMemoryDb.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(inMemoryDb.get(id));

    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return inMemoryDb.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findAny();
    }
}
