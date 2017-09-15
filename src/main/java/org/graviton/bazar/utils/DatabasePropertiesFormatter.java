package org.graviton.bazar.utils;

import java.util.Properties;

public class DatabasePropertiesFormatter {

    public static Properties format(Properties properties) {
        properties.keySet().removeIf(key -> !key.toString().contains("dataSource"));
        return properties;
    }

}
