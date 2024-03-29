package responsebody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateResponseBody {

	@Test(priority = 1)
	void validatejsonparsing() {
		
         given()
         .contentType("Content-Type.JSON")
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
        .body("book[2].title",equalTo("Moby Dick"));
	}
	
	@Test(priority = 2)
	void validatejsonparsing1() {
		
		Response res= given()
         .contentType("Content-Type.JSON")
		
		.when()
		.get("http://localhost:3000/store");
		 
		 Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		
		String bookname = res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(bookname, "Moby Dick");
	}
	
	@Test(priority = 3)
	void validatejsonparsing2() {
		
		Response res= given()
		         .contentType("Content-Type.JSON")
				
				.when()
				.get("http://localhost:3000/store");
				 
		        //using JSON object class
				JSONObject obj=new JSONObject(res.asString());  //converting response to JSON object
				
				
				/*for(int i=0;i<obj.getJSONArray("book").length();i++) {
					String bookstitle = obj.getJSONArray("book").getJSONObject(i).get("title").toString();
					System.out.println(bookstitle);
				}
	}*/
				boolean status=false;
	for(int i=0;i<obj.getJSONArray("book").length();i++) {
		String booktitle = obj.getJSONArray("book").getJSONObject(i).get("title").toString();
		if(booktitle.equals("Moby Dick")) {
			status=true;
			break;
		}
	}
	Assert.assertEquals(status, true);
}
	
	@Test(priority = 4)
	void validatejsonparsing3() {
		
		Response res= given()
		         .contentType("Content-Type.JSON")
				
				.when()
				.get("http://localhost:3000/store"); 
				 
		        //using JSON object class
				JSONObject obj=new JSONObject(res.asString());  //converting response to JSON object
				
				double totalprice=0;
				for(int i=0;i<obj.getJSONArray("book").length();i++) {
					String price = obj.getJSONArray("book").getJSONObject(i).get("price").toString();
					totalprice=totalprice+Double.parseDouble(price);
				}
					System.out.println("Total price of books is:"+totalprice);
					Assert.assertEquals(totalprice, 526.0);
				
	}
	}

