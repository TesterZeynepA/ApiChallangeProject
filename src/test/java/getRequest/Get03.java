package getRequest;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 {
/**
    Given
    https://jsonplaceholder.typicode.com/todos/23
    When
    User sends a GET Request to the URL
    Then
    HTTP Status Code should be 200
    And
    Response format should be "application/json"
    And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
    And
    "completed"  is false
    And
    "userid" is 2

    {
        "userId": 2,
            "id": 23,
            "title": "et itaque necessitatibus maxime molestiae qui quas velit",
            "completed": false
    }
*/

@Test
    public void get03(){

    String url ="https://jsonplaceholder.typicode.com/todos/23";

    Response response = given()
            .when().get(url);

    response.prettyPrint();

    response.then().assertThat()
            .statusCode(200)
            .contentType("application/json")
            .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
            ,"completed", equalTo(false),"userId",equalTo(2));

}


}
