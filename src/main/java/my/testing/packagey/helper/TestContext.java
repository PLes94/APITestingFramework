package my.testing.packagey.helper;

import io.restassured.response.Response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Data
public class TestContext {
    private Response response;
    private List<Integer> someListForConstructor;

    public TestContext() {
        someListForConstructor = new ArrayList<>();
    }

    public Response setResponse(Response response) {
        this.response = response;
        assertNotEquals(503, response.getStatusCode(), "Can't proceed, service is unavailable");
        return response;
    }

    public Response getResponse() {
        return response;
    }
}
