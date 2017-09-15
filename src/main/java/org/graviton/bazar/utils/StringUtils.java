package org.graviton.bazar.utils;

public class StringUtils {

    public static String getOrElse(String data, String alternative) {
        return data == null ? alternative : data;
    }

}
