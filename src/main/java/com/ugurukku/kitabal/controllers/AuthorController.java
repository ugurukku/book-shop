package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.dto.CategoryRequest;
import com.ugurukku.kitabal.entities.Author;
import com.ugurukku.kitabal.entities.Category;
import com.ugurukku.kitabal.services.AuthorService;
import com.ugurukku.kitabal.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody AuthorRequest authorRequest) {
        service.add(authorRequest);
        return new ResponseEntity<>("Yeni Müəllif uğurla əlavə edildi.", HttpStatus.CREATED);
    }


}
