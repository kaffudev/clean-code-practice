package com.kf.example.db.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.kf.example.db.hazelcast.model.UserDb;
import com.kf.example.domain.entity.User;
import com.kf.example.usecase.ports.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HazelcastUserRepository implements UserRepository {

    private static final HazelcastInstance HAZELCAST = Hazelcast.getInstance();
    private static final String MAP_NAME = "user";

    @Override
    public User create(User user) {
        var userDb = UserDb.from(user);
        var map = HAZELCAST.getMap(MAP_NAME);
        map.put(user.getId(), user);
        return user;

    }

    @Override
    public Optional<User> findById(String id) {
        var map = HAZELCAST.<String, UserDb>getMap(MAP_NAME);
        if (map.containsKey(id)) {
            var userdb = map.get(id);
            return Optional.of(userdb.toUser());
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        HAZELCAST.<String, UserDb>getMap(MAP_NAME)
                .values().stream()
                .filter(userDb -> userDb.toUser().getEmail().equals(email))
                .map(UserDb::toUser)
                .findAny();
        return Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        return HAZELCAST.<String, UserDb>getMap(MAP_NAME)
                .values().stream()
                .map(UserDb::toUser)
                .collect(Collectors.toList());
    }
}
