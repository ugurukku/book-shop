package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.SearchRequest;
import com.ugurukku.kitabal.dto.book.AllBookResponse;
import com.ugurukku.kitabal.dto.book.BookRequest;
import com.ugurukku.kitabal.dto.book.DetailedBookResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<AllBookResponse> getAll(SearchRequest searchRequest);

    void add(BookRequest bookRequest);

    DetailedBookResponse getById(Long id);
}
