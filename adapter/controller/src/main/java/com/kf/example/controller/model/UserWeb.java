package com.kf.example.controller.model;

import com.kf.example.domain.entity.User;

public class UserWeb {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User toUser() {
        return User.builder()
                .withId(id)
                .withPassword(password)
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }

    public static UserWeb toUserWeb(final User user) {
        var userWeb = new UserWeb();
        // do not map password
        userWeb.setId(user.getId());
        userWeb.setEmail(user.getEmail());
        userWeb.setFirstName(user.getFirstName());
        userWeb.setLastName(user.getLastName());
        return userWeb;
    }

}
