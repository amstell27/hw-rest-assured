package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

    public class SpecsReqresIn {
        public static RequestSpecification request = with()
                .baseUri("https://reqres.in/api/")
                .log().body();

        public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

