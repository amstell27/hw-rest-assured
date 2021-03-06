package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;


public class SpecsDemoWebShop {

    public static RequestSpecification requestDemo = with()
            .filter(withCustomTemplates())
            .baseUri("http://demowebshop.tricentis.com/addproducttocart/details/78/2")
            .body("addtocart_78.EnteredQuantity=1");

    public static ResponseSpecification responseDemo = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
