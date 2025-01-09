package org.example.rent_module.controller;

import lombok.RequiredArgsConstructor;
import org.example.rent_module.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.example.rent_module.constants.RentApartmentConstants.GET_FILE_URL;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping(GET_FILE_URL)
    public ResponseEntity<Resource> getFile(@PathVariable Long id) {

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileService.getFile(id));
    }
}
