package com.example.architect_module.service;

import com.example.architect_module.model.ActionInDbRequest;

import java.util.Map;

public interface ArchitectService {

    void executeAction(ActionInDbRequest request);
    void launchCreateTableCommand(ActionInDbRequest request);
    String generateCreateScript(String tableName, Map<String, String> columnNames);

}
