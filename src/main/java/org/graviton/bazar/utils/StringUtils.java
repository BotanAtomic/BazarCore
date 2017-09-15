package org.graviton.bazar.utils;

public class StringUtils {

    public static String getOrElse(String data) {
        return data == null ? "" : data;
    }

}
