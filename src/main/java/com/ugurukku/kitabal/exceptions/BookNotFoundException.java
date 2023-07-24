package com.ugurukku.kitabal.exceptions;

public class BookNotFoundException extends MainNotFoundException {
    public BookNotFoundException(Long id) {
        super("Book",id);
    }
}
