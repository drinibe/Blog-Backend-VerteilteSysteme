package ch.hftm;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BlogResourceTest {

    @Test
    public void testBlogEndpoint() {
        given()
          .when().get("/blog")
          .then()
             .statusCode(200)
             .body(is("Willkommen auf meinem Blog!"));
    }

}