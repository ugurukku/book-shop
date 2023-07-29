package com.ugurukku.kitabal.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ugurukku.kitabal.exceptions.ImageMediaTypeException;
import com.ugurukku.kitabal.exceptions.ImageSizeException;
import com.ugurukku.kitabal.services.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Value("${aws.bucket-name}")
    private String BUCKET_NAME;

    private final AmazonS3 amazonS3Client;


    @Override
    public void addImage(String filePrefix, Long id, MultipartFile file) {
        checkImage(file);
        File convertedFile = convertMultiToFile(file);
        PutObjectRequest objectRequest = new PutObjectRequest(BUCKET_NAME, filePrefix + "/" + id , convertedFile);
        amazonS3Client.putObject(objectRequest);

        if(convertedFile.delete()){
            log.info("Converted file added to S3 and successfully deleted.");
        }

    }

    private void checkImage(MultipartFile file) {
        if (file.getContentType() == null || !file.getContentType().startsWith("image")) {
            throw new ImageMediaTypeException("Şəkil fayllardan başqa fayllara icazə yoxdur!");
        }

        long maxSizeBytes = 10 * 1024 * 1024;
        if (file.getSize() > maxSizeBytes) {
            throw new ImageSizeException("Şəklin ölçüsü 10 mb dan böyük olmamalıdır!");
        }
    }

    private File convertMultiToFile(MultipartFile file) {

        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipart to file");
            throw new RuntimeException("Gözlənilməz bir xəta baş verdi!");
        }
        return convertedFile;
    }

}
