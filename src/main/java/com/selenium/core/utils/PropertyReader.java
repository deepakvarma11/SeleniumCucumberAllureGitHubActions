package com.selenium.core.utils;

import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    public static Properties properties;

    private PropertyReader() {

    }

    public static synchronized Properties getInstance() {
        if (Objects.isNull(properties)) {
            try {
                FileReader fileReader = new FileReader("src/main/resources/configs/config.properties");
                properties = new Properties();
                properties.load(fileReader);

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            return properties;
        }
        return properties;
    }
}
