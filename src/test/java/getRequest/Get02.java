package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class Get02 {

    /*
    Given
       https://restful-booker.herokuapp.com/booking/1001
    When
       User send a GET resquest to the URL
    Then
       HTTP Status Code should be 404
    And
       Status Line should be HTTP/1.1 404 Not Found
    And
       Response body contains "Not Found"
    And
       Headers Via nın "1.1 vegur" oldugunu assert et
    And
       Resonse body does not contain "CW"
    And
       Server is "Cowboy"
    */

    @Test

    public void get02(){

        String url = "https://restful-booker.herokuapp.com/booking/1001";


        Response response = given()
                .when()
                .get(url);

        response.prettyPrint();

        response.then().assertThat().statusCode(404);

        response.then().assertThat().statusLine("HTTP/1.1 404 Not Found" );

        String responseBodyStr = response.asString();
        System.out.println("responseBodyStr = " + responseBodyStr);

        Assert.assertTrue(responseBodyStr.contains("Not Found"));
        Assert.assertFalse(responseBodyStr.contains("CW"));

        Assert.assertEquals("1.1 vegur", response.getHeader("Via"));

        Assert.assertEquals("Cowboy", response.getHeader("Server"));

    }

}
