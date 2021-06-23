package com.kf.example;

import com.kf.example.config.ManualConfig;
import com.kf.example.domain.entity.User;

public class Main {
    public static void main(String[] args) {

        var config = new ManualConfig();
        var createUser = config.createUser();
        var findUser = config.findUser();
        var loginUser = config.loginUser();
        var user = User.builder()
                .withEmail("marianogor@gmail.com")
                .withPassword("marian99")
                .withFirstName("Marian")
                .withLastName("Ogor")
                .build();


        //create a user
        var actualCreateUser = createUser.create(user);
        System.out.println("LOG -- user created with id : " + user.getId());

        // find user by id
        var actualFindUser = findUser.findById(actualCreateUser.getId());
        System.out.println("LOG -- found user with id : " + actualCreateUser.getId());

        // list all users
        var users = findUser.findAllUsers();
        System.out.println("LOG -- find all users : " + users);

        //login
        loginUser.login("marianogor@gmail.com", "marian99");
        System.out.println("LOG -- allowed to log user with given credencials");

    }
}
