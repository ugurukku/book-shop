package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.CategoryRequest;
import com.ugurukku.kitabal.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void add(CategoryRequest categoryRequest);

}
