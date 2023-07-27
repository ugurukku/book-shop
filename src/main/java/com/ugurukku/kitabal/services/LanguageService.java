package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.LanguageRequest;
import com.ugurukku.kitabal.entities.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAll();

    void add(LanguageRequest languageRequest);
}
