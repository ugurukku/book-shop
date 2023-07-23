package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorRequest authorRequest);
}
