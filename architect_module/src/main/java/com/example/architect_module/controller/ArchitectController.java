package com.example.architect_module.controller;

import com.example.architect_module.model.ActionInDbRequest;
import com.example.architect_module.service.ArchitectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.architect_module.constants.ArchitectConstants.EXECUTE_URL;
import static com.example.architect_module.constants.ArchitectConstants.SUCCESS_MESSAGE;

@RestController
@RequiredArgsConstructor
public class ArchitectController {

    private final ArchitectService architectService;

    @PostMapping(EXECUTE_URL)
    public String executeActionInDb(@RequestBody ActionInDbRequest request) {
        architectService.executeAction(request);
        return SUCCESS_MESSAGE;
    }

    @PostMapping("/backup")
    public String backup() {
//        String command = "echo Metallica1983 | sudo -S docker exec -t atm_app pg_dump -U alexey -F t atm_db > architect_module/back.sql";
        String command = "echo Metallica1983 | sudo -S docker ps > architect_module/docker.txt";
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
        pb.redirectErrorStream(true);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "This is a backup controller.";
    }

}
