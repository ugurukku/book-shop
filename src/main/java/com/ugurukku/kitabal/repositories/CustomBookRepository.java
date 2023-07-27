package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.dto.SearchRequest;
import com.ugurukku.kitabal.entities.Book;

import java.util.List;

public interface CustomBookRepository {

    List<Book> findBySearchRequest(SearchRequest searchRequest);

}
