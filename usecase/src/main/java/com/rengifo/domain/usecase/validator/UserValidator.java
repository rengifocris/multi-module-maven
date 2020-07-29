package com.rengifo.domain.usecase.validator;

import com.rengifo.domain.entity.User;
import com.rengifo.domain.usecase.exception.UserValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static org.apache.commons.lang3.StringUtils.isBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserValidator {

    public static void validateCreateUser(@NonNull final User user) {
        if (isBlank(user.getEmail()))
            throw new UserValidationException("Email should not be null");
        if (isBlank(user.getFirstName()))
            throw new UserValidationException("First name should not be null");
        if (isBlank(user.getLastName()))
            throw new UserValidationException("Last name should not be null");
    }
}
