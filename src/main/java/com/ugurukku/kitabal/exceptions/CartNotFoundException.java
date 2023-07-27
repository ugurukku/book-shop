package com.ugurukku.kitabal.exceptions;

public class CartNotFoundException extends MainNotFoundException {
    public CartNotFoundException(Long id) {
        super("Cart", id);
    }
}
