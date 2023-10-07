package Homework.Task02;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Pojo02 {


    protected RequestSpecification specification;
    protected static String Api_Key;

    @BeforeMethod
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://api.themoviedb.org").build();

        Api_Key="4c841d9ec32b7f8c0069cf3fec36774f";

    }



}
