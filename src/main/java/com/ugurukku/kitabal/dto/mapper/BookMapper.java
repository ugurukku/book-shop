package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.book.AllBookResponse;
import com.ugurukku.kitabal.dto.book.BookRequest;
import com.ugurukku.kitabal.dto.book.DetailedBookResponse;
import com.ugurukku.kitabal.entities.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    AllBookResponse toAllBookResponse(Book book);

    List<AllBookResponse> toAllBookResponse(List<Book> book);

    Book toEntity(BookRequest bookRequest);

    DetailedBookResponse toDetailedBookResponse(Book book);

}
