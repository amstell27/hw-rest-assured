package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static specs.SpecsReqresIn.request;
import static specs.SpecsReqresIn.responseSpec;

public class APIReqresInTests {

    @Test
    void singleUser() {
        given()
                .spec(request)
                .when()
                .get("users/2")
                .then()
                .spec(responseSpec)
                .body("data.email", is("janet.weaver@reqres.in"));
    }

    @Test
    void registerUser() {
        String data = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";
        given()
                .spec(request)
                .body(data)
                .contentType(JSON)
                .when()
                .post("register")
                .then()
                .spec(responseSpec)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void createUser() {
        String data = "{\"name\": \"morpheus\",\"job\": \"leader\"\n}";
        given()
                .spec(request)
                .body(data)
                .contentType(JSON)
                .when()
                .post("users")
                .then()
                .statusCode(201)
                .body("job", is("leader"));
    }

    @Test
    void updateUser() {
        String data = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";
        given()
                .spec(request)
                .body(data)
                .contentType(JSON)
                .when()
                .patch("users/2")
                .then()
                .spec(responseSpec)
                .body("job", is("zion resident"));
    }

    @Test
    void deleteUser() {
        given()
                .spec(request)
                .when()
                .delete("users/2")
                .then()
                .statusCode(204);
    }

}
