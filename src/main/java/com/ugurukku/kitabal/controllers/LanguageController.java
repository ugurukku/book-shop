package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.LanguageRequest;
import com.ugurukku.kitabal.entities.Language;
import com.ugurukku.kitabal.services.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService service;

    @GetMapping
    public ResponseEntity<List<Language>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody LanguageRequest languageRequest) {
        service.add(languageRequest);
        return new ResponseEntity<>("Yeni Dil uğurla əlavə edildi.", HttpStatus.CREATED);
    }


}
