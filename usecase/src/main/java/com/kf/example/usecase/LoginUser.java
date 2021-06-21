package com.kf.example.usecase;

import com.kf.example.domain.entity.User;
import com.kf.example.usecase.exception.NotAllowedException;
import com.kf.example.usecase.ports.PasswordEncoder;
import com.kf.example.usecase.ports.UserRepository;

public class LoginUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {
        var user = userRepository.findUserByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
        var hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Not allowed");
        return user;

    }
}
