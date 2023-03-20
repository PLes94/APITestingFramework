package my.testing.packagey.stepdefinitions.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import my.testing.packagey.apimethods.ReqresUsersMethods;
import my.testing.packagey.stepdefinitions.StepDefinitions;
import my.testing.packagey.testdata.UsersTestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserByIdDefinitions extends StepDefinitions {

    @When("I send request to get a user by a specified id")
    public void iSendRequestToGetAUserByASpecifiedId() {
        testContext.setResponse(ReqresUsersMethods.getUserById(
                testContext.getTestData(UsersTestData.class).getUserId()));
    }

    @When("I set user id to be searched to {int}")
    public void iSetUserIdToBeSearchedTo(int userId) {
        testContext.getTestData(UsersTestData.class).setUserId(userId);
    }

    @And("I should get correct user id in response")
    public void iShouldGetCorrectUserIdInResponse() {
        assertEquals(testContext.getTestData(UsersTestData.class).getUserId(),
                testContext.getResponse().jsonPath().getInt("data.id"),
                "Found user id is incorrect");
    }
}
