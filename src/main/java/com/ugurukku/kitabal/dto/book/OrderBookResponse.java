package com.ugurukku.kitabal.dto.book;

public record OrderBookResponse(
        Long id,
        String name,
        Double price
) {
}
