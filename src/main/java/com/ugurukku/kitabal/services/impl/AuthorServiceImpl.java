package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.dto.book.AuthorResponse;
import com.ugurukku.kitabal.dto.mapper.AuthorMapper;
import com.ugurukku.kitabal.entities.Author;
import com.ugurukku.kitabal.entities.SequenceGeneratorService;
import com.ugurukku.kitabal.repositories.AuthorRepository;
import com.ugurukku.kitabal.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    private final SequenceGeneratorService sequenceGenerator;

    private final AuthorMapper mapper;

    @Override
    public List<AuthorResponse> getAll() {
        return mapper.toAuthorResponse(repository.findAll());
    }

    @Override
    public void add(AuthorRequest authorRequest) {
        Author author = mapper.toEntity(authorRequest);
        author.setId(sequenceGenerator.generateSequence(Author.SEQUENCE_NAME));
        repository.save(author);
    }
}
