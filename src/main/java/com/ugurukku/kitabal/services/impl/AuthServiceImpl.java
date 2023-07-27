package com.ugurukku.kitabal.services.impl;


import com.ugurukku.kitabal.dto.auth.LoginResponse;
import com.ugurukku.kitabal.dto.auth.RefreshTokenDto;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.dto.auth.RegisterRequest;
import com.ugurukku.kitabal.dto.mapper.UserMapper;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.exceptions.EmailAlreadyTakenException;
import com.ugurukku.kitabal.repositories.UserRepository;
import com.ugurukku.kitabal.security.AccessTokenManager;
import com.ugurukku.kitabal.security.RefreshTokenManager;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final SequenceGeneratorService sequenceGenerator;


    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        var user = userService.getByEmail(request.email());
        var accessToken = accessTokenManager.generate(user);
        var refreshToken = refreshTokenManager
                .generate(RefreshTokenDto
                        .builder()
                        .user(user)
                        .rememberMe(request.rememberMe())
                        .build());

        return LoginResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }


    public void register(RegisterRequest registerRequest) {
        if (userService.existsByEmail(registerRequest.email())){
            throw new EmailAlreadyTakenException();
        }

        User user = userMapper.toEntity(registerRequest);
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        userRepository.save(user);


    }
}
