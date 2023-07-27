package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.auth.LoginResponse;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.dto.auth.RegisterRequest;
import com.ugurukku.kitabal.services.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(service.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        return null;
    }


}
