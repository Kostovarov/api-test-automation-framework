package kz.template.api.service;

import io.restassured.response.Response;
import kz.template.api.config.ApiConfig;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.dto.response.UserResponse;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final String USERS_ENDPOINT = "/users";

    public ServiceResponse<UserResponse> getUserById(int userId) {
        Response response = sendGetUserByIdRequest(userId);

        return new ServiceResponse<>(response, UserResponse.class);
    }

    public ServiceResponse<Void> getUserByIdWithoutBody(int userId) {
        Response response = sendGetUserByIdRequest(userId);

        return new ServiceResponse<>(response, Void.class);
    }

    private Response sendGetUserByIdRequest(int userId) {
        return given()
                .spec(ApiConfig.requestSpecification())
                .pathParam("userId", userId)
                .when()
                .get(USERS_ENDPOINT + "/{userId}");
    }
}
