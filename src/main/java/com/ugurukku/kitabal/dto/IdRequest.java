package com.ugurukku.kitabal.dto;

import jakarta.validation.constraints.NotNull;

public record IdRequest(
        @NotNull
        Long id
) {
}
