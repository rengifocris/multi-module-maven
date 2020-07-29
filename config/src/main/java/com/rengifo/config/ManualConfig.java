package com.rengifo.config;

import com.rengifo.domain.usecase.CreateUser;
import com.rengifo.domain.usecase.FindUser;
import com.rengifo.domain.usecase.LoginUser;
import com.rengifo.domain.usecase.port.IdGenerator;
import com.rengifo.domain.usecase.port.PasswordEncoder;
import com.rengifo.domain.usecase.port.UserRepository;
import com.rengifo.encoder.Sha256PasswordEncoder;
import com.rengifo.idgenerator.JugIdGenerator;
import com.rengifo.repository.db.InMemoryUserRepository;

public class ManualConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }
}
