package kz.template.api.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import kz.template.api.utils.ConfigReader;

public final class ApiConfig {

    private static final RequestSpecification REQUEST_SPECIFICATION =
            buildRequestSpecification();

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private ApiConfig() {
    }

    public static RequestSpecification requestSpecification() {
        return REQUEST_SPECIFICATION;
    }

    private static RequestSpecification buildRequestSpecification() {
        int timeout = ConfigReader.getInt("request.timeout");

        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config()
                .httpClient(
                        HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", timeout)
                                .setParam("http.socket.timeout", timeout)
                                .setParam(
                                        "http.connection-manager.timeout",
                                        (long) timeout
                                )
                );

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setConfig(restAssuredConfig)
                .build();
    }
}