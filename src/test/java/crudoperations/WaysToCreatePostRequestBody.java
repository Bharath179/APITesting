package crudoperations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;


public class WaysToCreatePostRequestBody {

	@Test(priority = 1)
	void testPostusingHashmap() {
		HashMap<String, Object>data=new HashMap<String, Object>();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type","application/json")
		.log().all();
	}
	
	@Test(priority = 2)
	void testDelete() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/"+"b538")
		
		.then()
		.statusCode(200);
	}
}
