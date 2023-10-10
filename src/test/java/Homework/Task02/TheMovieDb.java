package Homework.Task02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.JsonPlacesHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TheMovieDb extends Pojo02{

     /**

// Base URL spec olarak kullanılmalıdır.

        Given
            https://api.themoviedb.org/3/movie/popular

            api_key = 4c841d9ec32b7f8c0069cf3fec36774f    ---> query params
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */

	 @Test

	public void task02(){

		 Response response = given()
				 .accept(ContentType.JSON)
				 .basePath("/3/movie/popular")
				 .queryParam("api_key", Api_Key)
				 .spec(specification).when()
				 .get("/3/movie/popular")
				 .then()
				 .extract().response();

		 response.then().assertThat()
				 .statusCode(200)
				 .contentType("application/json");

		 Map<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

		 Assert.assertEquals(actualMap.get("id"), actualMap.get(646389));
		 Assert.assertEquals(actualMap.get("id"), actualMap.get(536554));
		 Assert.assertEquals(actualMap.get("id"), actualMap.get(640146));


		 response.prettyPrint();



	 }


}
