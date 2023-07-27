package com.ugurukku.kitabal.dto.cart;

import com.ugurukku.kitabal.dto.book.OrderBookResponse;

public record CartOrderResponse(
        OrderBookResponse book,
        Integer quantity
) {
}
