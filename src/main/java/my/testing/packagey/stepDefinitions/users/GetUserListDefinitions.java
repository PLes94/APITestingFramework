package my.testing.packagey.stepDefinitions.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import my.testing.packagey.apimethods.ReqresMethods;
import my.testing.packagey.stepDefinitions.StepDefinitions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserListDefinitions extends StepDefinitions {

    @Test
    @DisplayName("My first test")
    public void myFirstTest() {
        MatcherAssert.assertThat(RestAssured.config(), Matchers.instanceOf(RestAssuredConfig.class));
    }

    @When("I send request to get list of users on page number = {}")
    public void iSendRequestToGetListOfUsersOnPageNumberEqualTo(int pageNumber) {
        testContext.setResponse(ReqresMethods.getListOfUsers(pageNumber));
    }

    @Then("I should get {} in response")
    public void iShouldGetGivenStatusCodeInResponse(int statusCode) {
        assertEquals(statusCode, testContext.getResponse().getStatusCode());
    }

    @And("I check if page number in response is equal to {}")
    public void iCheckIfPageNumberInResponseIsEqualTo(int pageNumber) {
        assertEquals(testContext.getResponse().jsonPath().getInt("page"), pageNumber, "Page number is incorrect");
    }
}
