package testCases;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Read_A_Product {

	@Test
	public void readAProduct() {

		Response response = 
				
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type","application/json; charset=UTF-8")
					.queryParam("id", "1111")
				.when()
					.get("/read_one.php")
				.then()
					.extract().response();
		
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response Body: " + responseBody);
		
		JsonPath jp = new JsonPath(responseBody);
		String productName = jp.getString("name");
		System.out.println(productName);
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	
		
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		
		System.out.println("Response Time: " + responseTime);
		if(responseTime<=2000) {
			
			System.out.println("Response time is within range");
			
		} else {
			System.out.println("Response time is out of range");
		}
		
		
		
	}
	
	
}
