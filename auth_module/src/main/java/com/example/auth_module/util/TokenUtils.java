package com.example.auth_module.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class TokenUtils {

    public static String generateToken() {
        return UUID.randomUUID() + "|" + LocalDateTime.now().plusDays(1L);
    }
}
