package com.ugurukku.kitabal.dto;

public record SearchRequest(

        Integer page,
        Integer count,
        Long authorId,
        Long categoryId,
        Long publisherId
) {
}
