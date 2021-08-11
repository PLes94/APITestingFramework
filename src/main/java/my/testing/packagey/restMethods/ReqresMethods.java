package my.testing.packagey.restMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresMethods {

    private static final String basicUrl = "https://reqres.in/api/";

    public static Response getListOfUsers(int pageNumber) {
        return RestAssured.given()
                .log().all()
                .queryParam("page", pageNumber)
                .contentType("application/json")
                .when()
                .relaxedHTTPSValidation()
                .get(basicUrl + "users")
                .then()
                .log().all()
                .extract().response();
    }
}
