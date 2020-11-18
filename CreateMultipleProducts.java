package PayPal;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateMultipleProducts {
	
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		
		String[] data = new String[3];
		data[0] = "./data/paypal.json";
		data[1] = "./data/paypal2.json";
		data[2] = "./data/paypal3.json";
		return data;
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createMultipleProducts(String filePath) {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products";
		
		File file = new File(filePath);
		Response response = RestAssured
				.given()
				.headers(
			              "Authorization",
			              "Bearer A21AAKYHxKSltP-2-ouesZjNDGbBR-C7pSTZ5042HTWrshrqUNj1N0LRIV2fZQOmQiT2U6MZjoLbHlASzlRN4-9K0uQOCKnFg",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				.body(file)
				.post();
				
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getContentType());
		response.prettyPrint();
		
		
		
	}

}
