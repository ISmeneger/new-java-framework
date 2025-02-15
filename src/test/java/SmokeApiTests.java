import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static constants.CommonConstants.BASE_URI;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {

    @Test
    void simpleTest() {
        // AAA - Arrange -> Act -> Assert
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .baseUri(BASE_URI)
                .when()
                    .body(body)
                    .post("user")
                .andReturn();

        int actualCode = response.getStatusCode();

        Assertions.assertEquals(200, actualCode);
    }
}
