package apigorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.testng.Assert.assertEquals;

public class getInactiveUser {


    @Test
    public void getInactiveUser () {
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://gorest.co.in");
        requestSpec.basePath("/public/v2/users").queryParam("status", "inactive").log().all();
        Response response = requestSpec.get();
        response.then().log().all();
        ResponseBody responseBody = response.getBody ();
        String responseString = responseBody.asString();
        System.out.println("Response body:" + responseString);
        Assert.assertEquals(responseString.contains("\"status\":\"inactive\""),true,"Check your body status bro");


    }
}
