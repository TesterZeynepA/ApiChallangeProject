package getRequest;

import baseURL.DummyRestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get06_JsonPath_GROVY extends DummyRestApi {
    /*
     Given
            https://dummy.restapiexample.com/api/v1/employees
     When
         Kullanıcı GET Methodu ile Request Gönderir
     Then
          Status Code un "200" olduğunu Assert et
     And
          employee_age i 55'ten büyük olanları konsola yazdırınız.
          8 tane olduğunu assert ediniz.
     And
         id si 17 den büyük olanları konsola yazdırınız
         7 tane olduğunu assert ediniz.
     And
         salary si 100.000'den az olanları konsola yazdırınız.
         Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
  */



    @Test

    public void get06(){
        //1. step : set the URL
        specification.pathParams("employeesPath", "employees");
         // 2. step: set the expected data

        // 3. step : send request

        Response response = given().spec(specification).when().get("/{employeesPath}");
        response.prettyPrint();

        //4. step : Do assertion

        //JsonPath --> json objeleri içinde rahat navigate etmeye yarayan bir class...

        JsonPath jsonPath = response.jsonPath();

       // task 1 :  employee_age i 55'ten büyük olanları konsola yazdırınız.
        //          8 tane olduğunu assert ediniz.

        List<Integer> emploeeAge = jsonPath.getList("data.employee_age");

        System.out.println("emploeeAge = " + emploeeAge);

        int counter =0;

        for (Integer w:emploeeAge) {
            if (w>55){

                counter++;
            }

        }
        System.out.println("counter = " + counter);

       Assert.assertEquals(8, counter);


    }

}
