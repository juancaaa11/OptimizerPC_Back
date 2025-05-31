package com.example.optimizerpc.models.services.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("secure_url").toString();
    }

    public String uploadBase64(String base64Image) throws IOException {

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        Map uploadResult = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());

        return (String) uploadResult.get("secure_url");
    }
}
