package kz.template.api.tests;

import kz.template.api.config.ApiConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiConfigTest {

    @Test
    public void shouldSendRequestsUsingApiConfig() {
        given()
                .spec(ApiConfig.requestSpecification())
        .when()
                .get("/users/1")
        .then()
                .statusCode(200);
    }
}
