package com.ugurukku.kitabal.services.impl;


import com.ugurukku.kitabal.dto.auth.LoginResponse;
import com.ugurukku.kitabal.dto.auth.RefreshTokenDto;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.security.AccessTokenManager;
import com.ugurukku.kitabal.security.RefreshTokenManager;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final AccessTokenManager accessTokenManager;

    private final RefreshTokenManager refreshTokenManager;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;


    public LoginResponse login(LoginRequest request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var user = userService.getByEmail(request.email());
        var accessToken = accessTokenManager.generate(user);
        var refreshToken = refreshTokenManager.generate(RefreshTokenDto.builder().user(user).rememberMe(request.rememberMe()).build());

        return LoginResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }


}
