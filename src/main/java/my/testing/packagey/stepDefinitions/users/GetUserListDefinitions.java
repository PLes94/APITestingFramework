package my.testing.packagey.stepDefinitions.users;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import my.testing.packagey.restMethods.ReqresMethods;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import my.testing.packagey.stepDefinitions.StepDefinitions;

public class GetUserListDefinitions extends StepDefinitions {
    @Test
    @DisplayName("My first test")
    public void myFirstTest() {
        MatcherAssert.assertThat(RestAssured.config(), Matchers.instanceOf(RestAssuredConfig.class));
    }

    @When("I check if page number in response is correct")
    public void checkPageNumberInResponse() {
        int pageNumber = 2;
        testContext.setResponse(RestAssured.get("https://reqres.in/api/users?page=" + pageNumber));
        Assertions.assertEquals(testContext.getResponse().jsonPath().getInt("page"), pageNumber, "Page number is incorrect");
    }

    @When("I check if page number in response is correct using methods class")
    public void checkPageNumberInResponseUsingMethodsClass() {
        int pageNumber = 2;
        testContext.setResponse(ReqresMethods.getListOfUsers(pageNumber));
//        Assertions.assertEquals(testContext.getResponse().jsonPath().getInt("page"), pageNumber, "Page number is incorrect");
    }

    @Then("I should get {} in response")
    public void iShouldGetGivenStatusCodeInResponse(int statusCode) {
        Assertions.assertEquals(statusCode, testContext.getResponse().getStatusCode());
    }
}
