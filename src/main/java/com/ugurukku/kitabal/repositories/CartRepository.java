package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart,Long> {
}
