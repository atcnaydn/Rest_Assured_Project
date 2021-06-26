package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PUT_Update_A_Product {

	@Test
	public void updateAProduct() {

//		https://techfios.com/api-prod/api/product
//		/read.php
		
		HashMap payload = new HashMap();
		payload.put("id", "1813");
		payload.put("name", "lightsaber");
		payload.put("description", "Darth Vader's Lightsaber");
		payload.put("price", "1138");
		payload.put("category_id", "2");

		Response response = 
				
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type","application/json; charset=UTF-8")
					.body(payload)
				.when()
					.put("/update.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
	
	}
	
	
}
