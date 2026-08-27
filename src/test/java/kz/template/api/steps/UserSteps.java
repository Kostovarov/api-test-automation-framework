package kz.template.api.steps;

import io.qameta.allure.Step;
import kz.template.api.dto.response.ServiceResponse;
import kz.template.api.dto.response.UserResponse;
import kz.template.api.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSteps {

    private final UserService userService = new UserService();

    @Step("Получить пользователя по id: {userId}")
    public ServiceResponse<UserResponse> getUserById(int userId) {
        return userService.getUserById(userId);
    }

    @Step("Получить пользователя по несуществующему id: {userId}")
    public ServiceResponse<Void> getUserByNotExistingId(int userId) {
        return userService.getUserByIdWithoutBody(userId);
    }

    @Step("Проверить id пользователя: {expectedUserId}")
    public void checkUserId(
            ServiceResponse<UserResponse> response,
            int expectedUserId
    ) {
        assertThat(response.getBody())
                .as("User response body")
                .isNotNull();

        assertThat(response.getBody().getId())
                .as("User id")
                .isEqualTo(expectedUserId);
    }

    @Step("Проверить, что email пользователя заполнен")
    public void checkEmailIsNotBlank(
            ServiceResponse<UserResponse> response
    ) {
        assertThat(response.getBody())
                .as("User response body")
                .isNotNull();

        assertThat(response.getBody().getEmail())
                .as("User email")
                .isNotBlank();
    }
}
