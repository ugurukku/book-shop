package com.ugurukku.kitabal;

import com.ugurukku.kitabal.dto.email.EmailDto;
import com.ugurukku.kitabal.utils.RabbitMQPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KitabalApplication{

    public static void main(String[] args) {
        SpringApplication.run(KitabalApplication.class, args);
    }


}
