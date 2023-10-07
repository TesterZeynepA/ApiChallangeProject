package getRequest;

import baseURL.GoRest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Get05 extends GoRest {

    /*
    Base URL Spec olarak kullanılmaldıır.
        Given
            https://gorest.co.in/public/v2/todos/28982
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
        And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
     {
    "id": 28982,
    "user_id": 5302532,
    "title": "Pecunia valens et molestias corpus suspendo vicinus.",
    "due_on": "2023-11-06T00:00:00.000+05:30",
    "status": "completed"
}
 */

    @Test
    public void get05(){
        specification.pathParams("todosPath", "todos", "idPath", "28982");

        //Object mapper :  Json --> Javaya çevirir..

        //1. pom.xml bir dependencies
        //2.convert işlemini sağlayan methodu oluşturmalıyız

        String expectedData = " {\n" +
                "    \"id\": 28982,\n" +
                "    \"user_id\": 5302532,\n" +
                "    \"title\": \"Pecunia valens et molestias corpus suspendo vicinus.\",\n" +
                "    \"due_on\": \"2023-11-06T00:00:00.000+05:30\",\n" +
                "    \"status\": \"completed\"\n" +
                "}";

        Map<String,Object> expectedMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");

        System.out.println("RESPONSE");

        response.prettyPrint();

        Map<String,Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

       assertEquals(expectedMap.get("id"), actualMap.get("id"));
       assertEquals(expectedMap.get("user_id"), actualMap.get("user_id"));
       assertEquals(expectedMap.get("title"), actualMap.get("title"));
       assertEquals(expectedMap.get("due_on"), actualMap.get("due_on"));
       assertEquals(expectedMap.get("status"), actualMap.get("status"));

       //2. yol : response Body

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(28982),
                        "user_id", equalTo(5302532),
                        "title", equalTo("Pecunia valens et molestias corpus suspendo vicinus."),
                        "due_on", equalTo("2023-11-06T00:00:00.000+05:30"),
                        "status", equalTo("completed"));


    }

}
