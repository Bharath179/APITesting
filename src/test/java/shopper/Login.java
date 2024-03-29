package shopper;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class Login {

	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGFyYXRoa24xNzlAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MTE1NjYwNTcsImlhdCI6MTcxMTUzMDA1N30.N89d5FF8T3EXzZaSsFCmKjV9KChSzhSXutzueYsiR9o";
	@Test
	void verifyLogin() throws FileNotFoundException {
		
		File f=new File(".\\body1.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://www.shoppersstack.com/shopping/users/login")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void getProducts() {
		
		//String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGFyYXRoa24xNzlAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MTE1NjYwNTcsImlhdCI6MTcxMTUzMDA1N30.N89d5FF8T3EXzZaSsFCmKjV9KChSzhSXutzueYsiR9o";
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		
		.when()
		.get("https://www.shoppersstack.com/shopping/products/alpha")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void addproductstoWishlist() {
		
		String data="{\r\n"
				+ "  \"productId\": 3488,\r\n"
				+ "  \"quantity\": 1\r\n"
				+ "}";
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("userId", "9729")
		.body(data.toString())
		
		.when()
		.post("https://www.shoppersstack.com/shopping/shoppers/{userId}/wishlist")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	@Test
	void deleteProductFromWishlist() {
		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.pathParam("userId", "9729")
		.pathParam("productId", "3488")
		
		.when()
		.delete("https://www.shoppersstack.com/shopping/shoppers/{userId}/wishlist/{productId}")
		
		.then()
		.statusCode(204)
		.log().all();
	}
	
}
