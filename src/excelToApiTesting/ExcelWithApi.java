package excelToApiTesting;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class ExcelWithApi {

	@Test
	public void addBook() {
		Map<String , Object> jsonHash = new HashMap<>();
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		jsonHash.put("name", "Learn Appium Automation with Java 3455");
		jsonHash.put("isbn", "bcd");
		jsonHash.put("aisle", "2926");
		jsonHash.put("author", "John fdfdf");
	   
			
	String resp=	
			given()
			.log().all()
			.header("Content-Type","application/json")
			.body(jsonHash)
		.when().post("Library/Addbook.php")
		.then()
			.log().all()
			.extract().asString();
	

	System.out.println("this is the response " +  resp);

}
}