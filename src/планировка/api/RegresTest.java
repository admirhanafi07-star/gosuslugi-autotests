package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class RegresTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void test(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+ "/src/планировка/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        int a = 0;
    }
}

//given() - с него начинаются все запросы по http протоколу