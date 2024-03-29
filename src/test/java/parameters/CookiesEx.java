package parameters;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesEx {

	@Test(priority = 1)
	void testCookies() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC", "Ae3NU9MkdOH7BEao13RMpQhRLk1Sa5-c_omDs1ZozykOdFgiXFZUOyZ3Zw")
		.log().all();
	}
	
	@Test
	void getCookies() {
		
       Response res= given()
		
		.when()
		.get("https://www.google.com/");
       
       //single cookie information
      // String cookie_value = res.getCookie("ACE");
       //System.out.println("The value of cookie is:"+cookie_value);
       
       //multiple cookies information
      Map<String, String> cookies_values = res.getCookies();
     // System.out.println("The value of cookies is:"+cookies_values.keySet());
      for (String k : cookies_values.keySet()) {
    	  String cookie_value = res.getCookie(k);
    	  System.out.println(k+"----"+cookie_value);
		
	}
	}
}
