package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Long> {
}
