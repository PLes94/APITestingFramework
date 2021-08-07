package methods;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresMethods {

    private static final String basicUrl = "https://reqres.in/api/";

    public static Response getListOfUsers(int pageNumber) {
        return given()
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
