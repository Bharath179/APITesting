package shopper;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class CartModule {

	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGFyYXRoa24xNzlAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MTE2MzkyMzgsImlhdCI6MTcxMTYwMzIzOH0.HPd17T4clJguGMwpVv81LxYAn2QGtdE8BEbjCNtjyoA";
	
	@Test
	void addProductToCart() {
		//String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGFyYXRoa24xNzlAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MTE2MzkyMzgsImlhdCI6MTcxMTYwMzIzOH0.HPd17T4clJguGMwpVv81LxYAn2QGtdE8BEbjCNtjyoA";
		
		String data="{\r\n"
				+ "  \"productId\": 3350,\r\n"
				+ "  \"quantity\": 1\r\n"
				+ "}";
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("userId", "9729")
		.body(data.toString())
		
		
		.when()
		.post("https://www.shoppersstack.com/shopping/shoppers/{userId}/carts")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	void upadteProduct() {
		
		String data="{\r\n"
				+ "  \"productId\": 2935,\r\n"
				+ "  \"quantity\": 2\r\n"
				+ "}";
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("userId", "9729")
		.pathParam("itemId", "126267")
		.body(data.toString())
		
		.when()
		.put("https://www.shoppersstack.com/shopping/shoppers/{userId}/carts/{itemId}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void deleteProduct() {
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("userId", "9729")
		.pathParam("productId", "3350")
		
		.when()
		.delete("https://www.shoppersstack.com/shopping/shoppers/{userId}/carts/{productId}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
