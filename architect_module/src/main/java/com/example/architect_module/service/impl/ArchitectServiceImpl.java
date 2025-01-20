package com.example.architect_module.service.impl;

import com.example.architect_module.model.ActionInDbRequest;
import com.example.architect_module.service.ArchitectService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

import static com.example.architect_module.constants.ArchitectConstants.*;

@Service
@RequiredArgsConstructor
public class ArchitectServiceImpl implements ArchitectService {

    private final JdbcTemplate jdbcTemplate;
    private final Flyway flyway;

    @Value("${spring.flyway.url}")
    private String url;

    @Value("${spring.flyway.user}")
    private String username;

    @Value("${spring.flyway.password}")
    private String password;

    @Override
    public void executeAction(ActionInDbRequest request) {

        if (CREATE_COMMAND.equals(request.getAction())) {
            launchCreateTableCommand(request);
        }

    }

    @Override
    public void backup() {
        ProcessBuilder pb = new ProcessBuilder(SH_COMMAND, SH_PARAM, DOCKER_BACKUP_COMMAND);
        pb.redirectErrorStream(true);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void launchCreateTableCommand(ActionInDbRequest request) {
        String fullScriptFileName = BEGIN_OF_FILE_NAME
                + (Integer.parseInt(Objects.requireNonNull(jdbcTemplate.queryForObject(SELECT_VERSION_QUERY, String.class))) + 1)
                + TWO_UNDERLINES
                + request.getAction()
                + UNDERLINE
                + request.getTableName()
                + END_OF_FILE_NAME;
        try {
            FileUtils.touch(new File(fullScriptFileName));

            Files.write(Paths.get(fullScriptFileName), generateCreateScript(request.getTableName(), request.getColumnNames()).getBytes());

            flyway.migrate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generateCreateScript(String tableName, Map<String, String> columnNames) {
        StringBuilder result = new StringBuilder();

        result.append(CREATE_TABLE).append(tableName).append(OPEN_BRACKET_AND_NEW_LINE);

        for (String columnName : columnNames.keySet()) {
            if (columnName.equals(ID_COLUMN)) {
                result.append(columnName).append(PRIMARY_KEY);
                continue;
            }
            result.append(columnName).append(SPACE).append(columnNames.get(columnName)).append(COMMA_AND_NEW_LINE);
        }

        result.deleteCharAt(result.length() - 2);

        return result.append(CLOSE_BRACKET_AND_NEW_LINE).append(CREATE_SEQUENCE).append(tableName).append(SEQUENCE_SUFFIX).toString();
    }
}