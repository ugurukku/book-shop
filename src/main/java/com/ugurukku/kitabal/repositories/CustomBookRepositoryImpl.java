package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.dto.SearchRequest;
import com.ugurukku.kitabal.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomBookRepositoryImpl implements CustomBookRepository {

    private final MongoOperations mongoOperations;

    @Override
    public List<Book> findBySearchRequest(SearchRequest searchRequest) {
        int page = searchRequest.page() == null ? 0 : searchRequest.page();
        int count = searchRequest.count() == null ? 10 : searchRequest.count();

        Criteria criteria = new Criteria();
        Query query;

        if (searchRequest.authorId() == null && searchRequest.categoryId() == null && searchRequest.publisherId() != null){
                query = new Query();
                query.with(PageRequest.of(page, count));
                return mongoOperations.find(query, Book.class);
        }else {
            if (searchRequest.authorId() != null) {
                criteria.and("authors").is(searchRequest.authorId());
            }  if (searchRequest.categoryId() != null) {
                criteria.and("categories").is(searchRequest.categoryId());
            }  if (searchRequest.publisherId() != null) {
                criteria.and("publisher").is(searchRequest.publisherId());
            }
        }

        query = new Query(criteria);
        query.with(PageRequest.of(page, count));
        return mongoOperations.find(query, Book.class);
    }
}
