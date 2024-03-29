package chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	void test_createUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearertoken="a439eb27ee99cfa518f05151420f6ea084153f3f3fb4c843407b2cac62930e2d";
		
		
		int id=given()
		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println("Generated id is:"+id);
		
		context.getSuite().setAttribute("user_id", id);
		
		
		
		
		
		
	}
}
