package my.testing.packagey.stepdefinitions.commons;

import io.cucumber.java.en.Then;
import my.testing.packagey.stepdefinitions.StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonsDefinitions extends StepDefinitions {

    @Then("I should get \"{int}\" in response")
    public void iShouldGetGivenStatusCodeInResponse(int expectedStatusCode) {
        int actualStatusCode = testContext.getResponse().getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode,
                "The response code is incorrect, I expected " + expectedStatusCode + ", but got " + actualStatusCode + " instead.");
    }
}
