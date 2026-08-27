package kz.template.api.tests;

import kz.template.api.utils.ConfigReader;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ConfigReaderTest {

    @Test
    public void shouldReadBaseUrlFromProperties() {
        assertThat(ConfigReader.get("base.url"))
                .as("Base URL should be loaded from application.properties")
                .isEqualTo("https://jsonplaceholder.typicode.com");
    }

    @Test
    public void shouldReadTimeoutAsInteger() {
        assertThat(ConfigReader.getInt("request.timeout"))
                .as("Request timeout be loaded as integer")
                .isEqualTo(10000);
    }
}
