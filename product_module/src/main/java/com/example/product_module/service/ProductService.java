package com.example.product_module.service;

import com.example.product_module.model.BookingInfoForProductDto;

public interface ProductService {

    String getVersion();

    void checkIntegrationKey(String integrationKey);

    String prepareDiscount(BookingInfoForProductDto info);
}
