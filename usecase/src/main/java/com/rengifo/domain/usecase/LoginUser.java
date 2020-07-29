package com.rengifo.domain.usecase;

import com.rengifo.domain.entity.User;
import com.rengifo.domain.usecase.exception.NotAllowedException;
import com.rengifo.domain.usecase.port.PasswordEncoder;
import com.rengifo.domain.usecase.port.UserRepository;
import lombok.var;

public final class LoginUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {

        var user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
        var hashedPassword = passwordEncoder.encode(email + password);

        if (!user.getPassword().equals(hashedPassword))
            throw new NotAllowedException("Not allowed");

        return user;
    }
}