package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.book.CartRequest;
import com.ugurukku.kitabal.dto.book.CartResponse;
import com.ugurukku.kitabal.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService service;


    @GetMapping("/{userId}")
    public ResponseEntity<CartResponse> getByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(service.getCartByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<String> addOrderToCart(@RequestBody CartRequest cartRequest){
        service.addOrderToCart(cartRequest);
        return new ResponseEntity<>("Mehsul ugurla elave edildi", HttpStatus.CREATED);
    }


}
