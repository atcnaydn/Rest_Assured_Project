
package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GET_Read_Products {

	@Test
	public void readAllProducts() throws IOException {
		

		Response response =

				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
				.when()
					.get("/read.php")
				.then()
					.extract().response();

		String responseBody = response.getBody().asPrettyString();

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		//There are too many values, my console doesnt list products so I write them to a txt here
		File file = new File("C:\\Users\\Ata Can Aydın\\Selenium\\RestAssuredAutomation\\Untitled 2");
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(responseBody.getBytes());

	}

}
