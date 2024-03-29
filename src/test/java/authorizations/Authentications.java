package authorizations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentications {

	@Test
	void basicAuthentication() {
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test
	void testBearerTokenAuthentication() {
		
		String bearerToken="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";
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void testOAuth1Authentication() {
		
		given()
		.auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void testOAuth2Authentication() {
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void testOAPIKeyAuthentication() {
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
