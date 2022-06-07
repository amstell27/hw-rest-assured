package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class SpecsDemoWebShop {
    public static RequestSpecification requestDemo = with()
            .baseUri("http://demowebshop.tricentis.com/addproducttocart/details/78/2")
            .body("addtocart_78.EnteredQuantity=1")
            .log().body();

    public static ResponseSpecification responseDemo = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
