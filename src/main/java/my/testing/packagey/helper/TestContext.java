package my.testing.packagey.helper;

import io.restassured.response.Response;
import lombok.Data;
import my.testing.packagey.testdata.TestData;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Data
public class TestContext {
    private Response response;
    private final Map<Class<?>, TestData> testData = new HashMap<>();

    public TestContext() {
    }

    public Response setResponse(Response response) {
        this.response = response;
        assertNotEquals(503, response.getStatusCode(), "Can't proceed, service is unavailable");
        return response;
    }

    public Response getResponse() {
        return response;
    }

    @SuppressWarnings("unchecked")
    public <T extends TestData> T getTestData(Class<T> testDataModelClass) {
        try {
            if (!testData.containsKey(testDataModelClass)) {
                testData.put(testDataModelClass, testDataModelClass.getDeclaredConstructor().newInstance());
            }
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (T) testData.get(testDataModelClass);
    }
}
