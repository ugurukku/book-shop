package com.ugurukku.kitabal.dto.comment;

import com.ugurukku.kitabal.dto.IdRequest;

public record CommentRequest(
        String content,
        IdRequest book
) {
}
