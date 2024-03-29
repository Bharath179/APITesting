package responsebody;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	@Test
	void test1() {                                                
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
	}
}
