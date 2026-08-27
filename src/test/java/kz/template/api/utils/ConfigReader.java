package kz.template.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final String CONFIG_PATH = "config/application.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigReader() {
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);

        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String propertyValue = PROPERTIES.getProperty(key);

        if (propertyValue == null || propertyValue.isBlank()) {
            throw new IllegalArgumentException(
                    "Property '%s' is not configured".formatted(key)
            );
        }

        return propertyValue;
    }

    public static int getInt(String key) {
        try {
            return Integer.parseInt(get(key));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Property '%s' must contain an integer value".formatted(key),
                    exception
            );
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream(CONFIG_PATH)) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "Configuration file not found: " + CONFIG_PATH
                );
            }

            properties.load(inputStream);
            return properties;

        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Failed to read configuration file: " + CONFIG_PATH,
                    exception
            );
        }
    }
}