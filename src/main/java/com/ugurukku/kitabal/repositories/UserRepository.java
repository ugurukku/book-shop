package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Long> {

    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);

}
