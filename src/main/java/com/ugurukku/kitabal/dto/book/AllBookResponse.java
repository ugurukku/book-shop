package com.ugurukku.kitabal.dto.book;

import java.util.List;

public record AllBookResponse(
        Long id,
        String name,
        Double price,
        List<AllBookAuthorResponse> authors
) {
}
