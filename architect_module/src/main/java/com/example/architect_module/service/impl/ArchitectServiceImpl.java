package com.example.architect_module.service.impl;

import com.example.architect_module.model.ActionInDbRequest;
import com.example.architect_module.service.ArchitectService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
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

    @Override
    public void executeAction(ActionInDbRequest request) {

        if (CREATE_COMMAND.equals(request.getAction())) {
            launchCreateTableCommand(request);
        }

    }

    @Override
    public void launchCreateTableCommand(ActionInDbRequest request) {
        String fullName = BEGIN_OF_FILE_NAME
                + (Integer.parseInt(Objects.requireNonNull(jdbcTemplate.queryForObject(SELECT_VERSION, String.class))) + 1)
                + TWO_UNDERLINES
                + request.getAction() + UNDERLINE
                + request.getTableName()
                + END_OF_FILE_NAME;
        try {
            FileUtils.touch(new File(fullName));

            Files.write(Paths.get(fullName), generateCreateScript(request.getTableName(), request.getColumnNames()).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generateCreateScript(String tableName, Map<String, String> columnNames) {
        StringBuilder result = new StringBuilder();

        result.append(CREATE_TABLE).append(tableName).append(" (\n");

        for (String columnName : columnNames.keySet()) {
            if (columnName.equals(ID_COLUMN)) {
                result.append(columnName).append(PRIMARY_KEY);
                continue;
            }
            result.append(columnName).append(" ").append(columnNames.get(columnName)).append(",\n");
        }

        result.deleteCharAt(result.length() - 2);

        return result.append(");\n").append(CREATE_SEQUENCE).append(tableName).append(SEQUENCE_SUFFIX).toString();
    }
}