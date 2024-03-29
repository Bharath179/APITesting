package chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void test_updateUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearertoken="a439eb27ee99cfa518f05151420f6ea084153f3f3fb4c843407b2cac62930e2d";
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
		
	}
}
