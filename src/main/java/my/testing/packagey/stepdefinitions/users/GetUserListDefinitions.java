package my.testing.packagey.stepdefinitions.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import my.testing.packagey.apimethods.ReqresUsersMethods;
import my.testing.packagey.stepdefinitions.StepDefinitions;
import my.testing.packagey.testdata.UsersTestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserListDefinitions extends StepDefinitions {

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
