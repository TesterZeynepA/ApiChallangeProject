package postRequest;

import baseURL.GoRest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoData.GoRestPOJO;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class post01 extends GoRest {

    /**
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et
        POST BODY :
     {"name": "Tenali Ramakrishna",
     "gender": "male",
     "email": "tenali223.ramakrishna@15ce.com",
     "status": "active"}
           HEADERS :
     Authorization : Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0
  */

    @Test

    public void post01(){
        specification.pathParams("usersPath", "users");

        GoRestPOJO expectedData = new GoRestPOJO();
        expectedData.setName("Zeynep Aytop");
        expectedData.setGender("female");
        expectedData.setEmail("ZeynepAytops454@gmaixl.com");
        expectedData.setStatus("active");

        Response response = given().spec(specification)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(expectedData)
                .header("Authorization", "Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0")
                .when().post("/{usersPath}");

        Map<String,Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualMap = " + actualMap);

        response.prettyPrint();

        Assert.assertEquals(expectedData.getStatus(),actualMap.get("status"));
        Assert.assertEquals(expectedData.getEmail(),actualMap.get("email"));
        Assert.assertEquals(expectedData.getName(),actualMap.get("name"));
        Assert.assertEquals(expectedData.getGender(),actualMap.get("gender"));




    }




}
