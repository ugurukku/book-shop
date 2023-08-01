package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.auth.LoginResponse;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.dto.auth.RegisterRequest;
import com.ugurukku.kitabal.services.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
        service.register(registerRequest);
        return new ResponseEntity<>("Doğrulama kodu email ünvanınıza göndərildi", HttpStatus.CREATED);
    }
    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam("email")String email,@RequestParam("code")String code){
        service.verify(email,code);
        return new ResponseEntity<>("Hesabınız uğurla təsdiqləndi",HttpStatus.OK);
    }



}
