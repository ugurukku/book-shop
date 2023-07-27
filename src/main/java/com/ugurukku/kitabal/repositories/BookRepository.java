package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends MongoRepository<Book,Long>, CustomBookRepository {


    @Query("{'authors' : :#{#authorId}}")
    Page<Book> findAllByAuthorId(@Param("authorId") Long authorId, Pageable pageable);

    @Query("{'categories' : :#{#categoryId}}")
    Page<Book> findAllByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

    @Query("{'publisher' : :#{#publisherId}}")
    Page<Book> findAllByPublisherId(@Param("publisherId") Long publisherId, Pageable pageable);


}
