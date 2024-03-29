package crudoperations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class Pojo {

	@Test
	void testusingPojo() {
		
		PojoEx data=new PojoEx();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		
		String courseArr[]= {"C","C++"};
		data.setCourses(courseArr);
		
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
		.delete("http://localhost:3000/students/"+"6a98")
		
		.then()
		.statusCode(200);
	}	
	}

