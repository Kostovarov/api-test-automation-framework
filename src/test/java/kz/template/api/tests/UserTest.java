package kz.template.api.tests;

import kz.template.api.assertions.ResponseAssertions;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.dto.response.UserResponse;
import kz.template.api.steps.UserSteps;
import org.testng.annotations.Test;

public class UserTest {

    private final UserSteps userSteps = new UserSteps();
    private final ResponseAssertions responseAssertions = new ResponseAssertions();

    @Test
    public void shouldGetUserById() {
        ServiceResponse<UserResponse> response =
                userSteps.getUserById(1);

        responseAssertions.assertStatusCode(response, 200);
        responseAssertions.assertBodyIsNotNull(response);

        userSteps.checkUserId(response, 1);
        userSteps.checkEmailIsNotBlank(response);
    }
}