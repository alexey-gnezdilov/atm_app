package org.example.rent_module.service;

import org.example.rent_module.entity.ApartmentInfo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void buildAndSaveFile(ApartmentInfo apartmentInfo, MultipartFile file);

    Resource getFile(Long id);
}
