package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.dto.book.AuthorResponse;

import java.util.List;

public interface AuthorService  {
    List<AuthorResponse> getAll();

    void add(AuthorRequest authorRequest);
}
