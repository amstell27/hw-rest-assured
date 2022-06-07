package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.http.Cookies;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static specs.SpecsDemoWebShop.requestDemo;
import static specs.SpecsDemoWebShop.responseDemo;

public class DemoWebShopTest {
    @Test
    void addToWishList() {
        given()
                .spec(requestDemo)
                .when()
                .post()
                .then()
                .spec(responseDemo)
                .body("success", is(true))
                .body("updatetopwishlistsectionhtml", is("(1)"));
    }

    @Test
    void addToWishListAssert() {
        String response =
        given()
                .spec(requestDemo)
                .when()
                .post()
                .then()
                .spec(responseDemo)
                .extract().response().asString();
        String expectResponse = "{\"success\":true,\"message\":\"The product has been added to your \\u003ca href=\\\"/wishlist\\\"\\u003ewishlist\\u003c/a\\u003e" +
                "\",\"updatetopwishlistsectionhtml\":\"(1)\"}";
        assertEquals(expectResponse, response);
    }

    @Test
    void addToWishListAndCheck() {
        Cookies authCookie =
                given()
                        .spec(requestDemo)
                        .when()
                        .post()
                        .then()
                        .spec(responseDemo)
                        .extract().detailedCookies();
        given()
                .cookie(authCookie.toString())
                .spec(requestDemo)
                .when()
                .post()
                .then()
                .spec(responseDemo)
                .body("success",is(false));
    }
}
