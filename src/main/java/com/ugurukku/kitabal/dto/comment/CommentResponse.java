package com.ugurukku.kitabal.dto.comment;

public record CommentResponse(
        String content,
        CommentUserResponse user
) {
}
