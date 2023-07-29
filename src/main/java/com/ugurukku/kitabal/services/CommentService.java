package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.comment.CommentRequest;
import com.ugurukku.kitabal.dto.comment.CommentResponse;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getAllByBookId(Long bookId);

    void add(CommentRequest commentRequest,Long userId);

}
