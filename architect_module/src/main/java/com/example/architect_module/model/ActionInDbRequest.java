package com.example.architect_module.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class ActionInDbRequest {

    private String action;
    private String tableName;
    private Map<String,String> columnNames;
}
