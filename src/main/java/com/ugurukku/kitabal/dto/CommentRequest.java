package com.ugurukku.kitabal.dto;

public record CommentRequest(
        String content,
        IdRequest book,
        IdRequest user
) {
}
