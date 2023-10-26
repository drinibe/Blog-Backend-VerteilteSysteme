package ch.hftm;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BlogResourceTest {

    public String accessToken;

    @BeforeEach
    public void setup() {

        String authEndpoint = "http://keycloak:8180/realms/blog";
        String clientId = "backend-service";
        String clientSecret = "CD44niEHXmpV2xsS0UCBskA5mgemKHE9";
        String username = "drinibe";
        String password = "3052";

        accessToken = given()
                .contentType("application/x-www-form-urlencoded")
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("username", username)
                .param("password", password)
                .param("grant_type", "password")
                .when()
                .post(authEndpoint)
                .then()
                .extract()
                .path("access_token");
        System.out.println(accessToken);
    }


    @Test
    public void testUpdateExistingBlog() {
        long existingBlogId = 1;  // Replace with an actual blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .contentType("application/json")
                .body("{\"title\":\"Updated Blog\",\"content\":\"Updated content.\"}")
                .when().put("/blogPosts/" + existingBlogId)
                .then()
                .statusCode(200);
        System.out.println(accessToken);
    }

    @Test
    public void testUpdateNonExistingBlog() {
        long nonExistingBlogId = 9999;  // Non-existing blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .contentType("application/json")
                .body("{\"title\":\"Updated Blog\",\"content\":\"Updated content.\"}")
                .when().put("/blogPosts/" + nonExistingBlogId)
                .then()
                .statusCode(404);  // Expecting not found
    }


    @Test
    public void testDeleteExistingBlog() {
        long existingBlogId = 1;  // Replace with an actual blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .when().delete("/blogPosts/" + existingBlogId)
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteNonExistingBlog() {
        long nonExistingBlogId = 9999;  // Non-existing blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .when().delete("/blogPosts/" + nonExistingBlogId)
                .then()
                .statusCode(404);  // Expecting not found
    }


    @Test
    public void testAddCommentToExistingBlog() {
        int existingBlogId = 1;  // Replace with an actual blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .contentType("application/json")
                .body("{\"comment\":\"This is a test comment.\"}")
                .when().post("/blogPosts/" + existingBlogId + "/comments")
                .then()
                .statusCode(201);
    }

    @Test
    public void testAddCommentToNonExistingBlog() {
        int nonExistingBlogId = 9999;  // Non-existing blog ID
        given()
                .header("Authorization", "Bearer" + accessToken)
                .contentType("application/json")
                .body("{\"comment\":\"This is a test comment.\"}")
                .when().post("/blogPosts/" + nonExistingBlogId + "/comments")
                .then()
                .statusCode(404);  // Expecting not found
    }
}
