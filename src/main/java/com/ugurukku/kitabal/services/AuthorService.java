package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.entities.Author;

import java.util.List;

public interface AuthorService  {
    List<Author> getAll();

    void add(AuthorRequest authorRequest);
}
