package com.rengifo.domain.usecase;

import com.rengifo.domain.entity.User;
import com.rengifo.domain.usecase.port.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public final class FindUser {

    private final UserRepository repository;

    /**
     * receive and Id to find an user
     * @param id
     * @return User
     */
    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }
}