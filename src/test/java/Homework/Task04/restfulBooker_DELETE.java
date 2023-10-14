package Homework.Task04;

import baseURL.RestfulBooker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;

public class restfulBooker_DELETE extends RestfulBooker {

     /*
        Given
            1)https://restful-booker.herokuapp.com/booking/1
            2)Auth olarak HEader da Cookie ile token=<token_value> gönderiniz
            (Bunun için önce bir token oluşmamız gerekiyor onun içinde post
            methodu kullanmalıyız : bakınız --> restful documnetation )
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */

/*

{

delete_bookingID: [1,5,7,8]
}
 */
private String token;
    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        token = getToken("admin", "password123");
    }


        @Test
        public void deleteBooking() {


            int bookingId = 5;

            Response response = given()
                    .cookie("token", token)
                    .delete("/booking/" + bookingId);

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            System.out.println("Status Kodu: " + statusCode);
            System.out.println("Yanıt: " + responseBody);


            Assert.assertEquals(statusCode, 201);
            Assert.assertTrue(responseBody.contains("Created"));
        }

        public String getToken(String username, String password) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                    .post("/auth");

            return response.jsonPath().getString("token");
        }
    }