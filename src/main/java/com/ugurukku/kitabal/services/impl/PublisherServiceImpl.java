package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.PublisherRequest;
import com.ugurukku.kitabal.dto.mapper.PublisherMapper;
import com.ugurukku.kitabal.entities.Publisher;
import com.ugurukku.kitabal.entities.SequenceGeneratorService;
import com.ugurukku.kitabal.repositories.PublisherRepository;
import com.ugurukku.kitabal.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;

    private final SequenceGeneratorService sequenceGenerator;

    private final PublisherMapper mapper;

    @Override
    public List<Publisher> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(PublisherRequest publisherRequest) {
        Publisher publisher = mapper.toEntity(publisherRequest);
        publisher.setId(sequenceGenerator.generateSequence(Publisher.SEQUENCE_NAME));
        repository.save(publisher);
    }

}
