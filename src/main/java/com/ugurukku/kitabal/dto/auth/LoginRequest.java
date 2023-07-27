package com.ugurukku.kitabal.dto.auth;

public record LoginRequest(
        String email,
        String password,
        Boolean rememberMe
) {
}
