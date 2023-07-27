package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.dto.book.AuthorResponse;
import com.ugurukku.kitabal.entities.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorRequest authorRequest);

    AuthorResponse toAuthorResponse(Author author);

    List<AuthorResponse> toAuthorResponse(List<Author> authors);
}
