package com.kf.example.usecase;

import com.kf.example.domain.entity.User;
import com.kf.example.usecase.exception.UserIsPresentException;
import com.kf.example.usecase.ports.IdGenerator;
import com.kf.example.usecase.ports.PasswordEncoder;
import com.kf.example.usecase.ports.UserRepository;
import com.kf.example.usecase.validator.UserValidator;

public class CreateUser {

    private final UserRepository repository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(final UserRepository repository, final IdGenerator idGenerator, final PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new UserIsPresentException(user.getEmail());
        }
         var userToSave = user.builder()
                .withId(idGenerator.generate())
                .withEmail(user.getEmail())
                .withPassword(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .build();

         return repository.create(userToSave);

    }

}
