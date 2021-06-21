package com.kf.example.usecase.validator;

import com.kf.example.domain.entity.User;
import com.kf.example.usecase.exception.UserValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserValidator {

    public static void validateCreateUser(User user) {
        if (user == null) throw new UserValidationException("user should not be null");
        if (isBlank(user.getEmail())) throw new UserValidationException("user can not be null");
        if (isBlank(user.getFirstName())) throw new UserValidationException("user should have first name");
        if (isBlank(user.getLastName())) throw new UserValidationException("user should have last name");

    }

    public UserValidator() {}

}
