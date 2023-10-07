package getRequest;

import baseURL.GoRest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoData.GoRestPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get08_Pojo extends GoRest {
 /**
       Given
           https://gorest.co.in/public/v2/users/5303088
      When
           Kullanıcı GET Methodu ile Request Gönderir
       Then
            Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
  {
  "id": 5301858,
  "name": "Kama Kakkar PhD",
  "email": "phd_kakkar_kama@lehner-rodriguez.test",
  "gender": "female",
  "status": "active"
  }
    */

 @Test
    public void get08(){

     specification.pathParams("usersPath","users","idPath", "5303088");

     GoRestPOJO expectedPojoData = new GoRestPOJO(5301858,"Kama Kakkar PhD",
             "phd_kakkar_kama@lehner-rodriguez.test","female","active");

     Response response = given()
             .spec(specification).when().get("/{usersPath}/{idPath}");

    GoRestPOJO actualData = response.as(GoRestPOJO.class);

     Assert.assertEquals(200, response.statusCode());

    Assert.assertEquals(expectedPojoData.getId(), actualData.getId());
   Assert.assertEquals(expectedPojoData.getName(), actualData.getName());
   Assert.assertEquals(expectedPojoData.getEmail(), actualData.getEmail());
    Assert.assertEquals(expectedPojoData.getGender(), actualData.getGender());
    Assert.assertEquals(expectedPojoData.getStatus(), actualData.getStatus());







 }


}
