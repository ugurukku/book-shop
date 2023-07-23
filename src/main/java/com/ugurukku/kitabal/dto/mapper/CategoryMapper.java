package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.CategoryRequest;
import com.ugurukku.kitabal.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequest categoryRequest);

}
