package ru.googlesearch.utils;

import java.io.IOException;
import java.util.Properties;


public class PropertyLoader {
    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream("/testdata.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}