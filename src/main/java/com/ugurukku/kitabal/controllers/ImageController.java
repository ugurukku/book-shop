package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService service;

    @PostMapping("/{filePrefix}/{id}")
    public ResponseEntity<String> addImage(@PathVariable("filePrefix") String filePrefix,
                                           @PathVariable("id") Long id,
                                           @RequestBody MultipartFile file) {
        service.addImage(filePrefix,id,file);

        return new ResponseEntity<>("Şəkil uğurla əlavə edildi", HttpStatus.CREATED);
    }

}
