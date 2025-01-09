package com.example.product_module.controller;

import com.example.product_module.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static com.example.product_module.constant.ProductModuleConstants.GET_VERSION_URL;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(GET_VERSION_URL)
    public String getVersion(@RequestHeader(required = true) String token) {
        if (!isNull(token) && !token.isEmpty()) {
            return productService.getVersion();
        }
        return "token is null";
    }
}
