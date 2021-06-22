package com.kf.example.db.hazelcast.model;

import com.kf.example.domain.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDb implements Serializable {

    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String role;

    public User toUser() {
        return User.builder()
                .withId(id)
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }

    public static UserDb from(final User user) {
        UserDb userDb = new UserDb();
        userDb.setId(user.getId());
        userDb.setEmail(user.getEmail());
        userDb.setPassword(user.getPassword());
        userDb.setLastName(user.getLastName());
        userDb.setFirstName(user.getFirstName());
        return userDb;
    }

}
