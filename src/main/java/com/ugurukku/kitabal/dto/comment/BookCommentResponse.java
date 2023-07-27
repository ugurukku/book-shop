package com.ugurukku.kitabal.dto.comment;

public record BookCommentResponse(
        String content,
        CommentUserResponse user
) {
}
