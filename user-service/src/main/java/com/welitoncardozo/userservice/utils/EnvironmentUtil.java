package com.welitoncardozo.userservice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvironmentUtil {
    private static final String HOSTNAME = "HOSTNAME";
    private static final String UNKNOWN = "unknown";

    public static String getHostname() {
        return System.getenv().getOrDefault(HOSTNAME, UNKNOWN);
    }
}
