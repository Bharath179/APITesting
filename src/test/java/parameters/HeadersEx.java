package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersEx {

	@Test(priority = 1)
	void getHeaders() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server", "gws");
		
	}
	
	@Test(priority = 2)
	void getMultipleHeaders() {
		
        Response res = given()
		
		.when()
		.get("https://www.google.com/");
        
        //single header information
        
       // String headervalue = res.getHeader("Content-Type");
       // System.out.println("The value of Content-header is:"+headervalue);
        
        //multiple headers information
        Headers headersvalues = res.getHeaders();
        for(Header hd:headersvalues) {
        	System.out.println(hd.getName()+"-------"+hd.getValue());
        }
	}
	
	@Test(priority = 3)
	void getHeader() {
		
         given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		//.log().body()
		//.log().headers()
		//.log().cookies()
		.log().all();
         
	}
}
