package com.ugurukku.kitabal.dto.book;


import java.util.Set;

public record CartResponse(
        Long id,

        Set<CartOrderResponse> orders
) {
}
