package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class RestfulBooker {


    protected RequestSpecification specification;

    @BeforeMethod
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
