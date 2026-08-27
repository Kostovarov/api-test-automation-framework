package kz.template.api.assertions;

import io.qameta.allure.Step;
import kz.template.api.dto.response.ServiceResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseAssertions {
    @Step("Проверить статус ответа: {expectedStatusCode}")
    public void assertStatusCode(
            ServiceResponse<?> response,
            int expectedStatusCode
    ) {
        assertThat(response.getStatusCode())
                .as("HTTP status code")
                .isEqualTo(expectedStatusCode);
    }

    @Step("Проверить, что тело ответа не пустое")
    public void assertBodyIsNotNull(ServiceResponse<?> response) {
        assertThat(response.getBody())
                .as("Response body")
                .isNotNull();
    }

    @Step("Проверить, что сырое тело ответа не пустое")
    public void assertRawBodyIsNotBlank(ServiceResponse<?> response) {
        assertThat(response.getRawBody())
                .as("Raw response body")
                .isNotBlank();
    }
}