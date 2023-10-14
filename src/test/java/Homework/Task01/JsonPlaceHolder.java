package Homework.Task01;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {

    /**
    Given
       https://jsonplaceholder.typicode.com/todos
    When
       I send a GET Request to the URL
    And
       Accept type is "application/json"
    Then
       HTTP Status Code should be 200
    And
       Response format should be "application/json"
    And
       There should be 200 todos
    And
       "quis ut nam facilis et officia qui" should be one of the title
    And
       2 , 7 , and 9 should be among the userIds
    */



    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void get01() {

        Response response = given()
                .when()
                .get("/todos");


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String contentType = response.getContentType();
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

        List<Map<String, Object>> todos = response.jsonPath().getList(".");

        Assert.assertEquals(todos.size(), 200);


        boolean titleFound = false;
        for (Map<String, Object> todo : todos) {
            if (todo.get("title").equals("quis ut nam facilis et officia qui")) {
                titleFound = true;
                break;
            }
        }
        Assert.assertTrue(titleFound);

        boolean userIdsFound = false;
        for (Map<String, Object> todo : todos) {
            int userId = (Integer) todo.get("userId");
            if (userId == 2 || userId == 7 || userId == 9) {
                userIdsFound = true;
                break;
            }
        }
        Assert.assertTrue(userIdsFound);
    }
}





