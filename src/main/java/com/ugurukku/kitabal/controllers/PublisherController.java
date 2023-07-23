package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.AuthorRequest;
import com.ugurukku.kitabal.dto.PublisherRequest;
import com.ugurukku.kitabal.entities.Author;
import com.ugurukku.kitabal.entities.Publisher;
import com.ugurukku.kitabal.services.AuthorService;
import com.ugurukku.kitabal.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService service;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PublisherRequest authorRequest) {
        service.add(authorRequest);
        return new ResponseEntity<>("Yeni Nəşriyyat uğurla əlavə edildi.", HttpStatus.CREATED);
    }

}
