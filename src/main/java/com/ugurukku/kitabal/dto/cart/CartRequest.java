package com.ugurukku.kitabal.dto.cart;

import com.ugurukku.kitabal.dto.IdRequest;

import java.util.List;

public record CartRequest(
        List<CartOrderRequest> orders,
        IdRequest user
) {
}
