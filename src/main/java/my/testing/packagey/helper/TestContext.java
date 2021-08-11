package my.testing.packagey.helper;

import io.restassured.response.Response;
import lombok.Data;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestContext {
    private Response response;
    private List<Integer> someListForConstructor;

    public TestContext() {
        someListForConstructor = new ArrayList<>();
    }

    public Response setResponse(Response response) {
        this.response = response;
        Assertions.assertNotEquals(503, response.getStatusCode(), "Can't proceed, service is unavailable");
        return response;
    }

    public Response getResponse() {
        return response;
    }
}
