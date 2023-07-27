package com.ugurukku.kitabal.dto.cart;


import java.util.Set;

public record CartResponse(
        Long id,

        Set<CartOrderResponse> orders
) {
}
