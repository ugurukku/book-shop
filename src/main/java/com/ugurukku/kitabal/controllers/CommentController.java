package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.IdRequest;
import com.ugurukku.kitabal.dto.comment.CommentRequest;
import com.ugurukku.kitabal.dto.comment.CommentResponse;
import com.ugurukku.kitabal.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public  ResponseEntity<String> add(@RequestBody CommentRequest commentRequest,
                                       @AuthenticationPrincipal Long userId){
        service.add(commentRequest,userId);
        return new ResponseEntity<>("Şərhiniz uğurla əlavə edildi.", HttpStatus.CREATED);
    }

}
