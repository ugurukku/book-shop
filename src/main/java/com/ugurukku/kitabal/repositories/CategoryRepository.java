package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Long> {
}
