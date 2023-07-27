package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.UserRequest;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody UserRequest userRequest){
        service.add(userRequest);
        return new ResponseEntity<>("İstifadəçi uğurla əlavə edildi", HttpStatus.CREATED);
    }

}
