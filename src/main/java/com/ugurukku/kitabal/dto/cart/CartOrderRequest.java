package com.ugurukku.kitabal.dto.cart;

import com.ugurukku.kitabal.dto.IdRequest;

public record CartOrderRequest(
        IdRequest book,

        Integer quantity
) {
}
