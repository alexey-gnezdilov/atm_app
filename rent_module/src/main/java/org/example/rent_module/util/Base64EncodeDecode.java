package org.example.rent_module.util;

import java.util.Base64;

public class Base64EncodeDecode {

    public static String encoder(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String decoder(String value) {
        return new String(Base64.getDecoder().decode(value));
    }
}
