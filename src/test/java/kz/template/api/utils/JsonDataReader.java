package kz.template.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public final class JsonDataReader {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonDataReader() {
    }

    public static <T> T read(String resourcePath, Class<T> dataClass) {
        try (InputStream inputStream =
                     JsonDataReader.class
                             .getClassLoader()
                             .getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalArgumentException(
                        "Test data file not found: " + resourcePath
                );
            }

            return OBJECT_MAPPER.readValue(inputStream, dataClass);

        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Failed to read test data file: " + resourcePath,
                    exception
            );
        }
    }
}