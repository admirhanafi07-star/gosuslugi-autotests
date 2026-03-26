package gosuslugi_autotests_selenium.gosuslugi_api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {
    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://www.gosuslugi.ru";
        RestAssured.basePath = "/api";

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}