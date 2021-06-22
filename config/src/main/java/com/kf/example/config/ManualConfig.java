package com.kf.example.config;

import com.kf.example.db.InMemoryUserRepository;
import com.kf.example.sha256encoder.Sha256PasswordEncoder;
import com.kf.example.usecase.CreateUser;
import com.kf.example.usecase.FindUser;
import com.kf.example.usecase.LoginUser;
import com.kf.example.usecase.ports.IdGenerator;
import com.kf.example.usecase.ports.PasswordEncoder;
import com.kf.example.usecase.ports.UserRepository;
import com.kf.example.uuid.UuidGenerator;

public class ManualConfig {

    private IdGenerator idGenerator = new UuidGenerator();
    private PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
    private UserRepository userRepository = new InMemoryUserRepository();

    public CreateUser createUser() {
        return new CreateUser(userRepository, idGenerator, passwordEncoder);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }
}
