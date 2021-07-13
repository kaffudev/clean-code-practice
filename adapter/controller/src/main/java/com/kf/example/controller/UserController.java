package com.kf.example.controller;

import com.kf.example.usecase.CreateUser;
import com.kf.example.usecase.FindUser;
import com.kf.example.usecase.LoginUser;
import com.kf.example.controller.model.UserWeb;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;
    private final LoginUser loginUser;


    public UserController(CreateUser createUser, FindUser findUser, LoginUser loginUser) {
        this.createUser = createUser;
        this.findUser = findUser;
        this.loginUser = loginUser;
    }

    public UserWeb createUser(final UserWeb userWeb) {
        var user = userWeb.toUser();
        return UserWeb.toUserWeb(createUser.create(user));
    }

    public UserWeb loginUser(final String email, final String password) {
        return UserWeb.toUserWeb(loginUser.login(email, password));
    }

    public UserWeb getUser(final String userId) {
        return UserWeb.toUserWeb(findUser.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found")));
    }

    public List<UserWeb> findAllUser() {
        return findUser.findAllUsers()
                .stream()
                .map(UserWeb::toUserWeb)
                .collect(Collectors.toList());
    }
}
