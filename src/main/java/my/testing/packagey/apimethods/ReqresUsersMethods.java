package my.testing.packagey.apimethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReqresUsersMethods {

    private static final String BASIC_URL = "https://reqres.in/api/users/";

    public static Response getListOfUsers(int pageNumber) {
        return RestAssured.given()
                .log().all()
                .queryParam("page", pageNumber)
                .contentType("application/json")
                .when()
                .relaxedHTTPSValidation()
                .get(BASIC_URL)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getUserById(int userId) {
        return RestAssured.given()
                .log().all()
                .contentType("application/json")
                .when()
                .relaxedHTTPSValidation()
                .get(BASIC_URL + userId)
                .then()
                .log().all()
                .extract().response();
    }
}
