import io.restassured.RestAssured;

import static  io.restassured.RestAssured.*;

import file.Payload;

public class PostBasic {

	public static void main(String[] args) {
	//Check if post method is working
		//given  - all input details
		//when  -  submit the API -resources, http  method
		//then - validation
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
			.log().all()
			.queryParam("key","qaclick123")
			.header("Content-Type","application/json")
			.body(Payload.payload())
		.when()
			.post("maps/api/place/add/json")
		.then()
			.log().all()
			.statusCode(200);
		
		
		
		
		

}
}
