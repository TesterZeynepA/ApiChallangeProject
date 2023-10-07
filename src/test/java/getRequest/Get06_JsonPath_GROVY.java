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


        //task 2 : id si 17 den büyük olanları konsola yazdırınız
       // 7 tane olduğunu assert ediniz.

        List<Integer> id = jsonPath.getList("data.id");

        System.out.println("id = " + id);

        int count =0;

        for (Integer f: id) {

            if (f>17){
                count++;
            }

        }
        System.out.println("count = " + count);

        Assert.assertEquals(7, count);
        //2. yol GROVY LANG.

        List<Integer> ids = jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("ids = " + ids);
        Assert.assertEquals(7, ids.size());

        List<Integer> idNames = jsonPath.getList("data.findAll{(it.id)>17}.employee_name");
        System.out.println("idNames = " + idNames);


        // task 3: salary si 100.000'den az olanları konsola yazdırınız.
        // Doris Wilder'ın bunlardan biri olduğunu assert ediniz.

        List<Integer> salaryList = jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("salaryList = " + salaryList);

        Assert.assertEquals("Doris Wilder", salaryList);


    }

}
