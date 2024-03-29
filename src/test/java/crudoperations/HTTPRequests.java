package crudoperations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {

	int id;
	@Test(priority = 1)
	void getUsers() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}

	@Test(priority = 2)
	void createUser() {
		
		HashMap<String, String>data=new HashMap<String, String>();
		data.put("name", "bharath");
		data.put("job", "QA");
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap<String, String>data=new HashMap<String, String>();
		data.put("name", "Kumar");
		data.put("job", "Software Engineer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users/"+id)
		
		.then()
	    .statusCode(201)
		.log().all();
	}
	
	@Test(priority = 4)
	void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		 .statusCode(204)
			.log().all();
	}
	}

