package com.ugurukku.kitabal;

import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.security.AccessTokenManager;
import com.ugurukku.kitabal.security.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.*;
import java.util.Base64;


@SpringBootApplication
@RequiredArgsConstructor
public class KitabalApplication  {

    private  final AccessTokenManager tokenManager;

    public static void main(String[] args) {
        SpringApplication.run(KitabalApplication.class, args);
    }





}
