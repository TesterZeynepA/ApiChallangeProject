package Homework.Task02;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class TheMovieDb extends Pojo02{

     /**

// Base URL spec olarak kullanılmalıdır.

        Given
            https://api.themoviedb.org/3/movie/popular

            api_key = 4c841d9ec32b7f8c0069cf3fec36774f    ---> query params
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */


		@BeforeClass
		public void setup() {
			RestAssured.baseURI = "https://api.themoviedb.org/3/movie/popular";
		}

		@Test
		public void testGet01() {

			given()
					.param("api_key", "4c841d9ec32b7f8c0069cf3fec36774f")
					.when()
					.get()
					.then()
					.statusCode(200)
					.contentType("application/json");
		}

	@Test
	public void testGet02() {

		String apiKey = "4c841d9ec32b7f8c0069cf3fec36774f";

		List<Integer> expectedIds = List.of(678512, 893723, 980489);

		List<Integer> actualIds = given()
				.param("api_key", apiKey)
				.when()
				.get()
				.then()
				.statusCode(200)
				.contentType("application/json")
				.extract().jsonPath().getList("results.id", Integer.class);

		for (int expectedId : expectedIds) {

			Assert.assertTrue(actualIds.contains(expectedId));
		}
	}
}
