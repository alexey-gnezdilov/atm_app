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
     * Tables names
     */
    public static final String PROMOCODES_TABLE= "promocodes_info";

    /**
     * Columns names
     */
    public static final String PROMOCODE_FIELD = "promocode";

    /**
     * Messages
     */
    public static final String NULL_TOKEN_MESSAGE = "Token is null";
    public static final String INVALID_INTEGRATION_KEY_MESSAGE = "Invalid integration key!";

    /**
     * Days of the week
     */
    public static final String SUNDAY = "SUNDAY";
    public static final String SATURDAY = "SATURDAY";

    public static final long ONE_WEEK_DAYS = 7L;
    public static final int AMOUNT_OF_BOOKINGS_FOR_REGULAR_CUSTOMER = 10;
    public static final int AMOUNT_OF_BOOKINGS_FOR_FREE_BOOKING = 100;
}
