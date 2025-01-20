package com.example.product_module.controller;

import com.example.product_module.model.BookingInfoForProductDto;
import com.example.product_module.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.product_module.constant.ProductModuleConstants.*;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(GET_VERSION_URL)
    public String getVersion(@RequestHeader(required = true) String token) {
        if (!isNull(token) && !token.isEmpty())
            return productService.getVersion();
        return NULL_TOKEN_MESSAGE;
    }

    @PostMapping(GET_DISCOUNT_URL)
    public String getDiscount(@RequestHeader String key,
                              @RequestBody BookingInfoForProductDto info) {
        productService.checkIntegrationKey(key);
        return productService.prepareDiscount(info);
    }
}
