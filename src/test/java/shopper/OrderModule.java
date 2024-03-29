package shopper;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class OrderModule {

	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGFyYXRoa24xNzlAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MTE2MzkyMzgsImlhdCI6MTcxMTYwMzIzOH0.HPd17T4clJguGMwpVv81LxYAn2QGtdE8BEbjCNtjyoA";
	
	@Test
	void orderProduct() {
		
	String data="{\r\n"
			+ "  \"address\": {\r\n"
			+ "    \"addressId\": 0,\r\n"
			+ "    \"buildingInfo\": \"udaybuilding\",\r\n"
			+ "    \"city\": \"Bangalore\",\r\n"
			+ "    \"country\": \"India\",\r\n"
			+ "    \"landmark\": \"canerabank\",\r\n"
			+ "    \"name\": \"KNB\",\r\n"
			+ "    \"phone\": \"9988776655\",\r\n"
			+ "    \"pincode\": \"560068\",\r\n"
			+ "    \"state\": \"Karnataka\",\r\n"
			+ "    \"streetInfo\": \"15thCross\",\r\n"
			+ "    \"type\": \"Home\"\r\n"
			+ "  },\r\n"
			+ "  \"paymentMode\": \"COD\"\r\n"
			+ "}";
	
	given()
	.headers("Authorization","Bearer "+token)
	.contentType("application/json")
	.pathParam("userId", "9729")
	.body(data.toString())
	
	
	.when()
	.post("https://www.shoppersstack.com/shopping/shoppers/{userId}/orders")
	
	.then()
	.statusCode(201)
	.log().all();
}
}
