package com.rengifo.domain.usecase;

import com.rengifo.domain.entity.User;
import com.rengifo.domain.usecase.exception.UserAlreadyExistsException;
import com.rengifo.domain.usecase.port.IdGenerator;
import com.rengifo.domain.usecase.port.PasswordEncoder;
import com.rengifo.domain.usecase.port.UserRepository;
import com.rengifo.domain.usecase.validator.UserValidator;
import lombok.AllArgsConstructor;
import lombok.var;

@AllArgsConstructor
public class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        var userToSave = User.builder()
                .id(idGenerator.generate())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
        return repository.create(userToSave);
    }
}
