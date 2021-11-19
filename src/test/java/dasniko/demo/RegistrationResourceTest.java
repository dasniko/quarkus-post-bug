package dasniko.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@QuarkusTest
public class RegistrationResourceTest {

    @Test
    public void testSucceedingRegistration() {
        given()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("eventId", "1234")
                .formParam("name", "John Doe")
                .formParam("email", "john.doe@example.com")
                .when()
                .post("/reg")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void testFailingRegistration() {
        given()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("eventId", "1234567890")
                .formParam("name", "John Doe")
                .formParam("email", "john.doe@example.com")
                .when()
                .post("/reg")
                .then()
                .statusCode(INTERNAL_SERVER_ERROR.getStatusCode());
    }
}
