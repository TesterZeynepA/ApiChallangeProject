package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class GoRest {

   protected RequestSpecification specification;

    @BeforeMethod
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v2").build();

    }


}
