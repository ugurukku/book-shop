package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.book.CartOrderRequest;
import com.ugurukku.kitabal.dto.book.CartRequest;
import com.ugurukku.kitabal.dto.book.CartResponse;
import com.ugurukku.kitabal.entities.Cart;
import com.ugurukku.kitabal.entities.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartResponse toCartResponse(Cart cart);

    Cart toEntity(CartRequest cartRequest);

    Order toOrderEntity(CartOrderRequest cartOrderRequest);

    List<Order> toOrderEntity(List<CartOrderRequest> orderRequests);
}
