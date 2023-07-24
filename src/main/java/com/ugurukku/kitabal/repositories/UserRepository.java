package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
}
