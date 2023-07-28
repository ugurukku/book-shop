package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Verifier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerifierRepository extends MongoRepository<Verifier,String> {
    boolean existsByEmailAndCode(String email,String code);
}
