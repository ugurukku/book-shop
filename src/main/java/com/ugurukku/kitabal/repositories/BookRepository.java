package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Long> {
}
