package crudoperations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;


public class JsonEx {

	@Test
	void testPostusingJsonLibrary() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
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
		.delete("http://localhost:3000/students/"+"75a4")
		
		.then()
		.statusCode(200);
	}

	}

