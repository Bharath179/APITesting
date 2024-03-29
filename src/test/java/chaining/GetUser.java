package chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	void test_getUser(ITestContext context) {
		
		String bearertoken="a439eb27ee99cfa518f05151420f6ea084153f3f3fb4c843407b2cac62930e2d";
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearertoken)
		.pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
