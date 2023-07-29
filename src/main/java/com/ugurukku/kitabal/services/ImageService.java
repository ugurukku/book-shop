package com.ugurukku.kitabal.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {


    void addImage(String filePrefix, Long id, MultipartFile file);
}
