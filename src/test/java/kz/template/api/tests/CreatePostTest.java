package kz.template.api.tests;

import kz.template.api.assertions.ResponseAssertions;
import kz.template.api.dto.request.CreatePostRequest;
import kz.template.api.dto.response.CreatePostResponse;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.steps.CreatePostSteps;
import kz.template.api.utils.JsonDataReader;
import org.testng.annotations.Test;

public class CreatePostTest {

    private final CreatePostSteps postSteps = new CreatePostSteps();
    private final ResponseAssertions responseAssertions =
            new ResponseAssertions();

    @Test
    public void shouldCreatePost() {
        CreatePostRequest request = JsonDataReader.read(
                "testdata/create-post.json",
                CreatePostRequest.class
        );

        ServiceResponse<CreatePostResponse> response =
                postSteps.createPost(request);

        responseAssertions.assertStatusCode(response, 201);
        responseAssertions.assertBodyIsNotNull(response);

        postSteps.checkCreatedPost(response, request);
    }
}