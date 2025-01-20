package com.example.product_module.constant;

public class ProductModuleConstants {

    /**
     * URL's
     */
    public static final String GET_VERSION_URL = "/get_version";
    public static final String GET_DISCOUNT_URL = "/get_discount";

    public static final String MODULE_VERSION = "${product.module-version}";
    public static final String PRODUCT_INTEGRATION_KEY = "${product.integration.key}";

    /**
     * Messages
     */
    public static final String NULL_TOKEN_MESSAGE = "Token is null";
    public static final String INVALID_INTEGRATION_KEY_MESSAGE = "Invalid integration key!";
}
