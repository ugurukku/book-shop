package com.ugurukku.kitabal.dto.book;

public record BookCommentResponse(
        String content,
        CommentUserResponse user
) {
}
