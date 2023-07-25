package com.ugurukku.kitabal.dto.book;

public record CartOrderResponse(
        OrderBookResponse book,
        Integer quantity
) {
}
