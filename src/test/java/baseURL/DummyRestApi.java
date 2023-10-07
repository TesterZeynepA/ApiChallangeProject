package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class DummyRestApi {

    protected RequestSpecification specification;

    @BeforeMethod
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();

    }





}
