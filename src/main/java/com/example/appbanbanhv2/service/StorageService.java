package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.imagemodel.FileData;
import com.example.appbanbanhv2.imagemodel.ImageData;
import com.example.appbanbanhv2.repository.FileDataRepository;
import com.example.appbanbanhv2.repository.StorageRepository;
import com.example.appbanbanhv2.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "/C:/Users/admin/Desktop/clone-get-image-android/file-storage/images/";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public String uploadImage(MultipartFile file, Long idProduct) throws IOException {
        ImageData imageDataNewest = new ImageData(0L,
                file.getOriginalFilename(),
                file.getContentType(),
                idProduct,
                ImageUtils.compressImage(file.getBytes())
        );
//        ImageData imageData = repository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes()))
//                .products_id(idProduct)
//                .build());
        ImageData res = repository.save(imageDataNewest);
        if (res != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}