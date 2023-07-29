package com.ugurukku.kitabal.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    public AWSCredentials credentials() {
        return new BasicAWSCredentials(
                "AKIA6ANW75BXD5SPOP2X",
                "Qb6fj7CLfb+lQw8dqi8IA1HwsK4Kf4IcnXBGrrV5"
        );
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(Regions.EU_NORTH_1)
                .build();
    }

}
