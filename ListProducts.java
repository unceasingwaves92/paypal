package PayPal;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListProducts {
	
	
		
	@Test
	public void listProducts() {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products/";
		
		
		Response response = RestAssured
				.given()
				.headers(
			              "Authorization",
			              "Bearer A21AAKYHxKSltP-2-ouesZjNDGbBR-C7pSTZ5042HTWrshrqUNj1N0LRIV2fZQOmQiT2U6MZjoLbHlASzlRN4-9K0uQOCKnFg",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				.get("?page_size=20&page=2&total_required=true");
				
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getContentType());
		
		
		JsonPath jsonResponse = response.jsonPath();
		List<String> list = jsonResponse.getList("products.id");
		System.out.println(list.get(5));
		System.out.println(list.get(6));
		System.out.println(list.get(7));
		
	}

}
