package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,Long> {
    List<Comment> findAllByBookId(Long bookId);
}
