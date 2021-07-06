package com.kf.example.config;

import com.kf.example.db.hazelcast.HazelcastUserRepository;
import com.kf.example.sha256encoder.Sha256PasswordEncoder;
import com.kf.example.usecase.CreateUser;
import com.kf.example.usecase.FindUser;
import com.kf.example.usecase.LoginUser;
import com.kf.example.usecase.ports.PasswordEncoder;
import com.kf.example.usecase.ports.UserRepository;
import com.kf.example.uuid.UuidGenerator;

public class SpringConfig {

    private final UserRepository repo = new HazelcastUserRepository();
    private final PasswordEncoder encoder = new Sha256PasswordEncoder();

    public CreateUser createUser () {
        return new CreateUser(repo, new UuidGenerator(), encoder);
    }

    public FindUser findUser() {
        return new FindUser(repo);
    }

    public LoginUser loginUser() {
        return new LoginUser(repo, encoder);
    }
}