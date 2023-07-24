package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.CommentRequest;
import com.ugurukku.kitabal.dto.book.CommentResponse;
import com.ugurukku.kitabal.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    @GetMapping("/book/{id}")
    public ResponseEntity<List<CommentResponse>> getAllByBookId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getAllByBookId(id));
    }

    @PostMapping
    public  ResponseEntity<String> add(@RequestBody CommentRequest commentRequest){
        service.add(commentRequest);
        return new ResponseEntity<>("Şərhiniz uğurla əlavə edildi.", HttpStatus.CREATED);
    }

}
