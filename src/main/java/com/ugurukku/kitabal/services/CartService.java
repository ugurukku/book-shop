package com.ugurukku.kitabal.services;


import com.ugurukku.kitabal.dto.cart.CartRequest;
import com.ugurukku.kitabal.dto.cart.CartResponse;

public interface CartService {

    CartResponse getCartByUserId(Long userId);

    void addOrderToCart(CartRequest request);

}
