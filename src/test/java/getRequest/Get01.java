package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class Get01 {

    /**
Given
    https://restful-booker.herokuapp.com/booking/7
When
    Kullanıcı GET Methodu ile Request Gönderir
Then
    Status Code un "200" olduğunu Assert et
And
    Content Type ın "application/json" olduğunu assert et
And
    Status Line "HTTP/1.1 200 OK" olduğunu assert et.

 */
    //1. adım : Set teh URL (url tanımla)
    //2. adım : Set expected data (beklenen datayı tanımla)
    //3. adım : Send request and get response (request gönder, response al)
    //4. adım : Do assertion (doğrula)

    @Test

    public void get01(){

        String url = "https://restful-booker.herokuapp.com/booking/7";

        Response response = given()
                .when()
                .get(url);

        System.out.println("RESPONSE");

        response.prettyPrint();

       response.then().assertThat().statusCode(200).toString();


        response.then().assertThat().contentType("application/json");
        response.then().assertThat().contentType(ContentType.JSON);

        response.then().assertThat().statusLine("HTTP/1.1 200 OK" );

        System.out.println(response.statusCode());

        System.out.println(response.getHeaders());










    }


}
