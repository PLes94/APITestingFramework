package my.testing.packagey.stepdefinitions.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import my.testing.packagey.apimethods.ReqresUsersMethods;
import my.testing.packagey.stepdefinitions.StepDefinitions;
import my.testing.packagey.testdata.UsersTestData;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserListDefinitions extends StepDefinitions {

    @Test
    @DisplayName("My first mock test")
    public void myFirstMockTest() {
        MatcherAssert.assertThat(RestAssured.config(), Matchers.instanceOf(RestAssuredConfig.class));
    }

    @When("I send request to get list of users on a specified page number")
    public void iSendRequestToGetListOfUsersOnASpecifiedPageNumber() {
        testContext.setResponse(ReqresUsersMethods.getListOfUsers(
                testContext.getTestData(UsersTestData.class).getPageNumber()));
    }

    @When("I set page number to be searched to {int}")
    public void iSetPageNumberToBeSearchedTo(int pageNumber) {
        testContext.getTestData(UsersTestData.class).setPageNumber(pageNumber);
    }

    @And("I should get correct page number in response")
    public void iShouldGetCorrectPageNumberInResponse() {
        assertEquals(testContext.getTestData(UsersTestData.class).getPageNumber(),
                testContext.getResponse().jsonPath().getInt("page"),
                "Page number is incorrect");
    }
}
