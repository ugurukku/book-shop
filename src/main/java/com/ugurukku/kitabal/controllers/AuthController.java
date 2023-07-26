package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.LoginResponse;
import com.ugurukku.kitabal.dto.RefreshTokenDto;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.security.AccessTokenManager;
import com.ugurukku.kitabal.security.RefreshTokenManager;
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

    private final AccessTokenManager accessTokenManager;

    private final RefreshTokenManager refreshTokenManager;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        User user = User.builder().id(1L).email(loginRequest.email()).password(loginRequest.password()).build();

        return ResponseEntity.ok(LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                        .refreshToken(refreshTokenManager.generate(
                                RefreshTokenDto.builder().user(user).rememberMe(loginRequest.rememberMe()).build()
                        ))
                .build());
    }


}
