package org.example.rent_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.entity.ApartmentAttachment;
import org.example.rent_module.entity.ApartmentInfo;
import org.example.rent_module.repository.FileCriteriaDaoRepository;
import org.example.rent_module.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.rent_module.constants.RentApartmentConstants.LOCAL_FILE_PATH;
import static org.example.rent_module.constants.RentApartmentConstants.PATH_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileCriteriaDaoRepository fileCriteriaDaoRepository;

    @Override
    public void buildAndSaveFile(ApartmentInfo apartmentInfo, MultipartFile file) {

        try {
            apartmentInfo.setFile(new ApartmentAttachment(
                    LOCAL_FILE_PATH,
                    file.getOriginalFilename(),
                    file.getSize(),
                    file.getContentType(),
                    file.getBytes()));
        } catch (Exception ignored) {}

        saveFileOnLocalStorage(file);
    }

    @Override
    public Resource getFile(Long id) {
        try {
            Path path = Files.write(Paths.get(LOCAL_FILE_PATH + "test.jpeg"), fileCriteriaDaoRepository.findById(id));
            return new InputStreamResource(
                    new FileInputStream(
                            new UrlResource(path.toUri()).getFile()));
        } catch (IOException ignored) {}
        return null;
    }

    private void saveFileOnLocalStorage(MultipartFile file) {
        try {
            Files.write(
                    Paths.get(LOCAL_FILE_PATH + file.getOriginalFilename()),
                    file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(PATH_EXCEPTION_MESSAGE);
        }
    }
}
