package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DELETE_A_Product {

	@Test
	public void updateAProduct() {
		HashMap payload = new HashMap();
		
		payload.put("id", "1111");
		
		Response response = 
				
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type","application/json; charset=UTF-8")
					.body(payload)
				.when()
					.put("/delete.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
	
	}
	
	
}
