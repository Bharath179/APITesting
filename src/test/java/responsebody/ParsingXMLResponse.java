package responsebody;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParsingXMLResponse {

	@Test
	void test1() {
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml");
	}
}
