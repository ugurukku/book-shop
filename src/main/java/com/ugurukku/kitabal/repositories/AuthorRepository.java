package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author,Long> {
}
