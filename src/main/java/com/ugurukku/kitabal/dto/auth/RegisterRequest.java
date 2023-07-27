package com.ugurukku.kitabal.dto.auth;

public record RegisterRequest(
        String email,
        String password
) {
}
