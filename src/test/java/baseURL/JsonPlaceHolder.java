package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class JsonPlaceHolder {

    protected RequestSpecification specification;

    @BeforeMethod
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }

}
