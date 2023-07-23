package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.CategoryRequest;
import com.ugurukku.kitabal.entities.Category;
import com.ugurukku.kitabal.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody CategoryRequest categoryRequest) {
        service.add(categoryRequest);
        return new ResponseEntity<>("Yeni kateqoriya uğurla əlavə edildi.", HttpStatus.CREATED);
    }


}
