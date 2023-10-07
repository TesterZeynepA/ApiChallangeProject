package getRequest;

import baseURL.JsonPlaceHolder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.JsonPlacesHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Get07_TestData extends JsonPlaceHolder {

    /**
    Given
       https://jsonplaceholder.typicode.com/todos/198
    When
       User sends a GET Request to the URL
    Then
       HTTP Status Code should be 200
    And
       Response body should be like
 {
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
  */

    @Test

    public void get07(){
        //1. adım : set the url
        specification.pathParams("todosPath", "todos", "idPath", "198");

        //2. adım: set the expected data --> testData class açalım

        JsonPlacesHolderTestData jsonPlacesHolderTestData= new JsonPlacesHolderTestData();

        Map<String,Object> expectedMap = jsonPlacesHolderTestData.setUpDataTodos();

        //3. step: send request

        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");
         //response u map e çevirelim

        //1. yol

        Map<String,Object> actualMap01 = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        //2. yol

        Map<String,Object> actualMap = response.as(HashMap.class); // De- ser.

        //4. step : Do Assertion

        Assert.assertEquals(expectedMap.get("userId"),actualMap.get("userId"));
        Assert.assertEquals(expectedMap.get("id"),actualMap.get("id"));
        Assert.assertEquals(expectedMap.get("title"),actualMap.get("title"));
        Assert.assertEquals(expectedMap.get("completed"),actualMap.get("completed"));


    }


}
