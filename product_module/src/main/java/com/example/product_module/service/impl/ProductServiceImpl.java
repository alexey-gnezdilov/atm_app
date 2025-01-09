package com.example.product_module.service.impl;

import com.example.product_module.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.product_module.constant.ProductModuleConstants.MODULE_VERSION;

@Service
public class ProductServiceImpl implements ProductService {

    @Value(MODULE_VERSION)
    private String currentVersion;

    @Override
    public String getVersion() {
        return currentVersion;
    }
}
