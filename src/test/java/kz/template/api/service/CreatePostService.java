package kz.template.api.service;

import io.restassured.response.Response;
import kz.template.api.config.ApiConfig;
import kz.template.api.dto.request.CreatePostRequest;
import kz.template.api.dto.response.CreatePostResponse;
import kz.template.api.dto.response.ServiceResponse;

import static io.restassured.RestAssured.given;

public class CreatePostService {

    private static final String POSTS_ENDPOINT = "/posts";

    public ServiceResponse<CreatePostResponse> createPost(
            CreatePostRequest request
    ) {
        Response response = given()
                .spec(ApiConfig.requestSpecification())
                .body(request)
                .when()
                .post(POSTS_ENDPOINT);

        return new ServiceResponse<>(
                response,
                CreatePostResponse.class
        );
    }
}