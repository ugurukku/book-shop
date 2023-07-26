package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.CategoryRequest;
import com.ugurukku.kitabal.dto.mapper.CategoryMapper;
import com.ugurukku.kitabal.entities.Category;
import com.ugurukku.kitabal.repositories.CategoryRepository;
import com.ugurukku.kitabal.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final SequenceGeneratorService sequenceGenerator;

    private final CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(CategoryRequest categoryRequest) {
        Category category = mapper.toEntity(categoryRequest);
        category.setId(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME));
        repository.save(category);
    }

}
