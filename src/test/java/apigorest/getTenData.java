package apigorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class getTenData {

    @Test
    public  void getTenUsers () {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Response response = given()
                .log().all()
                .contentType("application/json")
                .when()
                .get("/public/v2/users");
        response.then().log().all();
        List<Object> responseBody = response.jsonPath().getList("$");
        int expectedSize = 10;
        int actualSize = responseBody.size();
        assertEquals(actualSize, expectedSize, "Response body size is not as expected");
    }
}
