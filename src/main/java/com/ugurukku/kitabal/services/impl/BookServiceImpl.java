package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.book.AllBookResponse;
import com.ugurukku.kitabal.dto.book.BookRequest;
import com.ugurukku.kitabal.dto.book.DetailedBookResponse;
import com.ugurukku.kitabal.dto.mapper.BookMapper;
import com.ugurukku.kitabal.entities.Book;
import com.ugurukku.kitabal.entities.SequenceGeneratorService;
import com.ugurukku.kitabal.exceptions.BookNotFoundException;
import com.ugurukku.kitabal.repositories.BookRepository;
import com.ugurukku.kitabal.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final SequenceGeneratorService sequenceGenerator;

    private final BookMapper mapper;

    @Override
    public List<AllBookResponse> getAll(Pageable pageable) {
        return mapper.toAllBookResponse(repository.findAll(pageable).getContent());
    }

    @Override
    public void add(BookRequest bookRequest) {
        Book book = mapper.toEntity(bookRequest);
        book.setId(sequenceGenerator.generateSequence(Book.SEQUENCE_NAME));
        repository.save(book);
    }

    @Override
    public DetailedBookResponse getById(Long id) {
        Book book = repository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return mapper.toDetailedBookResponse(book);
    }
}
