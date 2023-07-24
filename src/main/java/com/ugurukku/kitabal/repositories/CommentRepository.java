package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,Long> {
}
