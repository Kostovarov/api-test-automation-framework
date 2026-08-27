package kz.template.api.tests;

import kz.template.api.assertions.ResponseAssertions;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.steps.UserSteps;
import org.testng.annotations.Test;

public class UserNotFoundTest {

    private static final int NOT_EXISTING_USER_ID = 999999;
    private static final int NOT_FOUND_STATUS_CODE = 404;

    private final UserSteps userSteps = new UserSteps();
    private final ResponseAssertions responseAssertions = new ResponseAssertions();

    @Test
    public void shouldReturnNotFoundForNotExistingUserId() {
        ServiceResponse<Void> response =
                userSteps.getUserByNotExistingId(NOT_EXISTING_USER_ID);

        responseAssertions.assertStatusCode(response, NOT_FOUND_STATUS_CODE);
    }
}
