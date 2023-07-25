package com.ugurukku.kitabal.dto.book;

import com.ugurukku.kitabal.dto.IdRequest;

public record CartOrderRequest(
        IdRequest book,

        Integer quantity
) {
}
