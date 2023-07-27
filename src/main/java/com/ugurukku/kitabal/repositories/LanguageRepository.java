package com.ugurukku.kitabal.repositories;

import com.ugurukku.kitabal.entities.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language,Long> {
}
