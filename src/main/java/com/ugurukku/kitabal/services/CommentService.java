package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.CommentRequest;
import com.ugurukku.kitabal.dto.book.CommentResponse;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getAllByBookId(Long bookId);

    void add(CommentRequest commentRequest);

}
