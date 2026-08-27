package kz.template.api.steps;

import io.qameta.allure.Step;
import kz.template.api.dto.request.CreatePostRequest;
import kz.template.api.dto.response.CreatePostResponse;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.service.CreatePostService;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePostSteps {

    private final CreatePostService postService = new CreatePostService();

    @Step("Создать новый пост")
    public ServiceResponse<CreatePostResponse> createPost(
            CreatePostRequest request
    ) {
        return postService.createPost(request);
    }

    @Step("Проверить данные созданного поста")
    public void checkCreatedPost(
            ServiceResponse<CreatePostResponse> response,
            CreatePostRequest expected
    ) {
        CreatePostResponse actual = response.getBody();

        assertThat(actual)
                .as("Create post response body")
                .isNotNull();

        assertThat(actual.getTitle())
                .as("Post title")
                .isEqualTo(expected.getTitle());

        assertThat(actual.getBody())
                .as("Post body")
                .isEqualTo(expected.getBody());

        assertThat(actual.getUserId())
                .as("Post user id")
                .isEqualTo(expected.getUserId());

        assertThat(actual.getId())
                .as("Created post id")
                .isPositive();
    }
}