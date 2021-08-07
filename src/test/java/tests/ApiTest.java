package tests;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import methods.ReqresMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class ApiTest {
    @Test
    @DisplayName("My first test")
    public void myFirstTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    @Test
    @DisplayName("Check if page number in response is correct")
    public void checkPageNumberInResponse() {
        int pageNumber = 2;
        Response response = RestAssured.get("https://reqres.in/api/users?page=" + pageNumber);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(response.jsonPath().getInt("page"), pageNumber, "Page number is incorrect");
    }

    @Test
    @DisplayName("Check if page number in response is correct using methods class")
    public void checkPageNumberInResponseUsingMethodsClass() {
        int pageNumber = 2;
        Response response = ReqresMethods.getListOfUsers(pageNumber);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(response.jsonPath().getInt("page"), pageNumber, "Page number is incorrect");
    }
}
