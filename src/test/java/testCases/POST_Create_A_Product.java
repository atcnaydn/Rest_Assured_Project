package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class POST_Create_A_Product {

	@Test
	public void readAProduct() {

//		https://techfios.com/api-prod/api/product
//		/read.php
		
		HashMap payload = new HashMap();
		payload.put("name", "table");
		payload.put("description", "tennis table");
		payload.put("price", "2187");
		payload.put("category_id", "2");

		Response response = 
				
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type","application/json; charset=UTF-8")
					.body(payload)
				.when()
					.post("/create.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		Assert.assertEquals(statusCode, 201);
	
	}
	
	
}
