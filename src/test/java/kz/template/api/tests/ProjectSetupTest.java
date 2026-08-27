package kz.template.api.tests;

import  org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectSetupTest {

    @Test
    public void shouldRunApiTestProject() {
        assertThat(true)
                .as("API test project should run")
                .isTrue();
    }
}
