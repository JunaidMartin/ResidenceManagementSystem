package com.systemsmart.util;

import java.util.UUID;

public class StringHelper {

    public static String generateRandom() {
        return UUID.randomUUID().toString();
    }
}
