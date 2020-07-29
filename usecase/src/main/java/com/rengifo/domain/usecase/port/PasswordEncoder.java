package com.rengifo.domain.usecase.port;

public interface PasswordEncoder {
    String encode(final String str);
}
