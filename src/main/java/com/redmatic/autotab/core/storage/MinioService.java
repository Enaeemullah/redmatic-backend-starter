package com.redmatic.autotab.core.storage;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MinioService {

    private MinioClient minioClient;

    @Value("${minio.url}")
    private String minioUrl;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Value("${minio.bucket}")
    private String bucketName;

    @PostConstruct
    public void initializeMinio() {
        minioClient = MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(accessKey, secretKey)
                .build();
    }

    public String uploadFile(MultipartFile file) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }

            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            try (InputStream stream = file.getInputStream()) {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(filename)
                                .stream(stream, file.getSize(), -1)
                                .contentType(file.getContentType())
                                .build()
                );
            }

            return String.format("%s/%s/%s", minioUrl, bucketName, filename);


        } catch (Exception e) {
            log.error("Failed to upload file to MinIO", e);
            throw new RuntimeException("Error uploading file to MinIO", e);
        }
    }
}
