package Homework.task03;

import baseURL.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoData.JsonPlaceHolderPOJO;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder_PUT extends JsonPlaceHolder {
     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
     */

    @Test

    public void put01(){
        specification.pathParams("todosPath", "todos", "idPath", "198");

        JsonPlaceHolderPOJO expectedData = new JsonPlaceHolderPOJO();
        expectedData.setUserId(7);
        expectedData.setTitle("Bu böyle yarım kalmayacak...");
        expectedData.setCompleted(true);

        Response response = given().spec(specification)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(expectedData)
                .when().put("/{todosPath}/{idPath}");

        Map<String,Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualMap = " + actualMap);

        response.prettyPrint();

        Assert.assertEquals(expectedData.getUserId(), actualMap.get("userId"));
        Assert.assertEquals(expectedData.getTitle(), actualMap.get("title"));
    }




}
