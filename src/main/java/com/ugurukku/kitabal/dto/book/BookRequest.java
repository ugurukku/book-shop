package com.ugurukku.kitabal.dto.book;

import com.ugurukku.kitabal.dto.IdRequest;

import java.util.Set;

public record BookRequest(

        String name,

        String description,

        Integer page,

        Integer stock,

        Double price,

        Set<IdRequest> authors,

        Set<IdRequest> categories,

        IdRequest publisher,

        IdRequest language
        ) {
}
