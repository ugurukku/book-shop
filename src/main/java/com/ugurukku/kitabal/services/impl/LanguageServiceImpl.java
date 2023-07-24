package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.LanguageRequest;
import com.ugurukku.kitabal.dto.mapper.LanguageMapper;
import com.ugurukku.kitabal.entities.Language;
import com.ugurukku.kitabal.entities.SequenceGeneratorService;
import com.ugurukku.kitabal.repositories.LanguageRepository;
import com.ugurukku.kitabal.services.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;

    private final LanguageMapper mapper;

    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public List<Language> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(LanguageRequest languageRequest) {
        Language language = mapper.toEntity(languageRequest);
        language.setId(sequenceGenerator.generateSequence(Language.SEQUENCE_NAME));
        repository.save(language);
    }
}
