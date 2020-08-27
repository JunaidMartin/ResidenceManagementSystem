package com.systemsmart.util;

import java.util.UUID;

public class GenericHelper {
    public static String generateRandom() {
        return UUID.randomUUID().toString();
    }
}
