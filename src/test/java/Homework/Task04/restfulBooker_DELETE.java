package Homework.Task04;

import baseURL.RestfulBooker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoData.BookingDates;
import pojoData.JsonPlaceHolderPOJO;
import pojoData.RestfulBookerPOJO;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

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

POST ile bookinge post etitğimiz zaaman delete edebiliriz.
{
    "firstname": "Marker",
    "lastname": "Smithchi",
    "totalprice": 487,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2021-09-14",
        "checkout": "2022-03-09"
    }
}



{

delete_bookingID: [1,5,7,8]
}
 */

    @Test
    public void post01(){
        specification.pathParams("bookingPath", "booking");




        RestfulBookerPOJO expectedData = new RestfulBookerPOJO();
        expectedData.setFirstname("Zeynep");
        expectedData.setLastname("Aytop");
        expectedData.setTotalprice(571);
        expectedData.setDepositpaid(true);




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







}