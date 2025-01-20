package com.example.product_module.service.impl;

import com.example.product_module.model.BookingInfoForProductDto;
import com.example.product_module.service.ProductService;
import com.example.product_module.util.Base64EncodeDecode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.product_module.constant.ProductModuleConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Value(MODULE_VERSION)
    private String currentVersion;

    @Value(PRODUCT_INTEGRATION_KEY)
    private String nativeIntegrationKey;

    @Override
    public String getVersion() {
        return currentVersion;
    }

    @Override
    public void checkIntegrationKey(String integrationKey) {
        if (!nativeIntegrationKey.equals(Base64EncodeDecode.encoder(integrationKey)))
            throw new RuntimeException(INVALID_INTEGRATION_KEY_MESSAGE);
    }

    @Override
    public String prepareDiscount(BookingInfoForProductDto info) {
        //TODO написать логику подбора скидки
        return "";
    }
}
