package org.graviton.bazar.utils;

import lombok.extern.slf4j.Slf4j;
import org.graviton.bazar.build.Build;

@Slf4j
public class Header {
    private final static String ASCII_HEADER = "                 _____                     _  _                \n                / ____|                   (_)| |               \n               | |  __  _ __  __ _ __   __ _ | |_  ___   _ __  \n               | | |_ || '__|/ _` |\\ \\ / /| || __|/ _ \\ | '_ \\ \n               | |__| || |  | (_| | \\ V / | || |_| (_) || | | |\n                \\_____||_|   \\__,_|  \\_/  |_| \\__|\\___/ |_| |_|\n";

    public static void build() {
        System.out.println(ASCII_HEADER);
        System.out.println();

        log.info("Server build : {}", Build.BUILD_VERSION);
    }


}
