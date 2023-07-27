package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart,Long> {

    Optional<Cart> findCartByUserId(Long userId);

}
