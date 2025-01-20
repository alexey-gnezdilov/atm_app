package com.example.architect_module.controller;

import com.example.architect_module.model.ActionInDbRequest;
import com.example.architect_module.service.ArchitectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.architect_module.constants.ArchitectConstants.*;

@RestController
@RequiredArgsConstructor
public class ArchitectController {

    private final ArchitectService architectService;

    @PostMapping(EXECUTE_URL)
    public String executeActionInDb(@RequestBody ActionInDbRequest request) {
        architectService.executeAction(request);
        return SUCCESS_EXECUTE_MESSAGE;
    }

    @PostMapping(BACKUP_URL)
    public String backup() {
        architectService.backup();
        return SUCCESS_BACKUP_MESSAGE;
    }

}
