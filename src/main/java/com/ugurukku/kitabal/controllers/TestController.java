package com.ugurukku.kitabal.controllers;

import com.ugurukku.kitabal.dto.email.EmailDto;
import com.ugurukku.kitabal.utils.RabbitMQPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final RabbitMQPublisher publisher;

    @GetMapping("/rabbit")
    public void rabbit() {
        EmailDto emailDto = EmailDto.builder()
                .recipient("ugurkarimli1@gmail.com")
                .subject("FutureShapers")
                .message("Siz qalib olmusunuz")
                .build();

        publisher.send(emailDto);
    }
}
