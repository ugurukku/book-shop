package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.book.CartRequest;
import com.ugurukku.kitabal.dto.book.CartResponse;
import com.ugurukku.kitabal.dto.mapper.CartMapper;
import com.ugurukku.kitabal.entities.Cart;
import com.ugurukku.kitabal.exceptions.CartNotFoundException;
import com.ugurukku.kitabal.repositories.CartRepository;
import com.ugurukku.kitabal.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    private final CartMapper mapper;

    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public CartResponse getCartByUserId(Long userId) {
        return mapper.toCartResponse(repository
                .findCartByUserId(userId)
                .orElseThrow(()-> new CartNotFoundException(userId)));
    }

    @Override
    public void addOrderToCart(CartRequest request) {
        Optional<Cart> optionalCart = repository.findCartByUserId(request.user().id());

        if (optionalCart.isPresent()){
            Cart cart = optionalCart.get();
            cart.getOrders().addAll(mapper.toOrderEntity(request.orders()));
            repository.save(cart);
        }else {
            Cart cart = mapper.toEntity(request);
            cart.setId(sequenceGenerator.generateSequence(Cart.SEQUENCE_NAME));
            repository.save(cart);
        }


    }
}
