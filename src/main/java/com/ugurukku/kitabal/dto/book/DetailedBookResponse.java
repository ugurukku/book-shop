package com.ugurukku.kitabal.dto.book;

import com.ugurukku.kitabal.dto.IdNameResponse;
import com.ugurukku.kitabal.dto.comment.BookCommentResponse;
import com.ugurukku.kitabal.entities.*;

import java.util.List;

public record DetailedBookResponse(

        Long id,

        String name,

        String description,

        Integer page,

        Integer rate,

        Integer stock,

        Double price,

        List<IdNameResponse> authors,

        List<Category> categories,

        Publisher publisher,

        Language language,

        List<BookCommentResponse> comments
) {
}
