package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.SearchRequest;
import com.ugurukku.kitabal.dto.book.AllBookResponse;
import com.ugurukku.kitabal.dto.book.BookRequest;
import com.ugurukku.kitabal.dto.book.DetailedBookResponse;
import com.ugurukku.kitabal.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    @PostMapping("/all")
    public ResponseEntity<List<AllBookResponse>> getAll(@RequestBody SearchRequest searchRequest) {

        return ResponseEntity.ok(service.getAll(searchRequest));
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody BookRequest bookRequest) {
        service.add(bookRequest);
        return new ResponseEntity<>("Yeni Kitab uğurla əlavə edildi.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedBookResponse> getAll(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
