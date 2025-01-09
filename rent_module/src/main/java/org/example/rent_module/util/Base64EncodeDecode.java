package org.example.rent_module.util;

import java.util.Base64;

public class Base64EncodeDecode {

    public static String encoder(String value) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(value.getBytes());
    }

    public static String decoder(String value) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(value);
        return new String(decode);
    }
}
