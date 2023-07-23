package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher,Long> {
}
