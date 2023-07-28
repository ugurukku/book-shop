package com.ugurukku.kitabal.services.impl;


import com.ugurukku.kitabal.dto.auth.LoginResponse;
import com.ugurukku.kitabal.dto.auth.RefreshTokenDto;
import com.ugurukku.kitabal.dto.auth.LoginRequest;
import com.ugurukku.kitabal.dto.auth.RegisterRequest;
import com.ugurukku.kitabal.dto.email.EmailDto;
import com.ugurukku.kitabal.dto.mapper.UserMapper;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.exceptions.EmailAlreadyTakenException;
import com.ugurukku.kitabal.repositories.UserRepository;
import com.ugurukku.kitabal.security.AccessTokenManager;
import com.ugurukku.kitabal.security.RefreshTokenManager;
import com.ugurukku.kitabal.services.UserService;
import com.ugurukku.kitabal.services.VerifierService;
import com.ugurukku.kitabal.utils.RabbitMQPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    private final VerifierService verifierService;
    private final RabbitMQPublisher rabbitMQPublisher;


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

        if (userService.existsByEmail(registerRequest.email())) {
            throw new EmailAlreadyTakenException();
        }

        insertUser(registerRequest);

        String verificationCode = UUID.randomUUID().toString();
        verifierService.add(registerRequest.email(), verificationCode);
        sendEmail(registerRequest.email(), verificationCode);
    }

    public void verify(String email, String verificationCode) {
        verifierService.verify(email, verificationCode);
        User user = userService.getByEmail(email);
        user.setIsActive(true);
        userRepository.save(user);
    }

    private void sendEmail(String email, String verificationCode) {

        String senderName = "Kitabal.az";
        String subject = "Hesabı təsdiqləmə";
        String content = "Əziz istifadəçimiz, <br>"
                + "Təsdiqləmə linkiniz:<br>"
                + "<a href=\"http://localhost:8080/api/auth/verify?email=[[email]]&code=[[verificationCode]]\">Zəhmət olmasa klikləyin</a> <br>"
                + "Təşəkkür edirik,<br>"
                + senderName;

        content = content.replace("[[email]]", email);
        content = content.replace("[[verificationCode]]", verificationCode);
        System.out.println(content);

        EmailDto verification = EmailDto.builder()
                .recipient(email)
                .subject(subject)
                .message(content)
                .isHtml(true)
                .build();

        rabbitMQPublisher.send(verification);
    }

    private void insertUser(RegisterRequest registerRequest) {
        User user = userMapper.toEntity(registerRequest);
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        userRepository.save(user);
    }
}
