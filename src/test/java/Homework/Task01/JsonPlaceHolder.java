package Homework.Task01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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


    @Test

    public void task01(){
        baseURI= "https://jsonplaceholder.typicode.com/todos";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

      response.then().assertThat().contentType("application/json");


       Map<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

       Assert.assertEquals(actualMap.get("userId"), actualMap.get(2));
       Assert.assertEquals(actualMap.get("userId"), actualMap.get(7));
       Assert.assertEquals(actualMap.get("userId"), actualMap.get(9));


        response.prettyPrint();








    }



}


