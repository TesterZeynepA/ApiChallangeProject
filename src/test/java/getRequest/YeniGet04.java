package getRequest;

import baseURL.GoRest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class YeniGet04 extends GoRest {

     /**
        Given
            https://gorest.co.in/public/v2/users/5297888
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

	  {
	  "id": 5297888,
	  "name": "Adheesh Gupta",
	  "email": "gupta_adheesh@botsford-boehm.test",
	  "gender": "female",
	  "status": "active"
	  }
     */

     @Test
    public void get04() {

		 //https://gorest.co.in/public/v2/users/5297888

		specification.pathParams("usersPath", "users", "idPath", "5297888");

		String expectedData = " {\n" +
				"\t  \"id\": 5297888,\n" +
				"\t  \"name\": \"Adheesh Gupta\",\n" +
				"\t  \"email\": \"gupta_adheesh@botsford-boehm.test\",\n" +
				"\t  \"gender\": \"female\",\n" +
				"\t  \"status\": \"active\"\n" +
				"\t  }";

		 Map<String,Object> expectedMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

		 Response response = given()
				 .spec(specification).when()
				 .get("/{usersPath}/{idPath}");

		 Map<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

		 Assert.assertEquals(expectedMap.get("id"), actualMap.get("id"));
		 Assert.assertEquals(expectedMap.get("name"), actualMap.get("name"));
		 Assert.assertEquals(expectedMap.get("email"), actualMap.get("email"));
		 Assert.assertEquals(expectedMap.get("gender"), actualMap.get("gender"));
		 Assert.assertEquals(expectedMap.get("status"), actualMap.get("status"));















     }








}
