package com.ugurukku.kitabal.services;


import com.ugurukku.kitabal.dto.book.CartRequest;
import com.ugurukku.kitabal.dto.book.CartResponse;

public interface CartService {

    CartResponse getCartByUserId(Long userId);

    void addOrderToCart(CartRequest request);

}
