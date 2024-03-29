package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class PathAndQueryParameters {

	@Test
	void testQueryAndPathParameters() {
		
		given()
		.pathParam("mypath", "users")       //path parameters
		.queryParam("page", 2)              //query parameters
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
