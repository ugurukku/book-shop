package com.ugurukku.kitabal.dto.book;

public record CommentResponse(
        String content,
        CommentUserResponse user
) {
}
