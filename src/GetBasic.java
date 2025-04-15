import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetBasic {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	Response response =	given()
			.log().all()
			.queryParam("key","qaclick123")
			.queryParam("place_id","c8422855cc02765768358b6aa6e53188").header("Content-Type","application/json")
		.when()
			.get("maps/api/place/get/json")
		.then()
			.log().all()
			.assertThat()
				.statusCode(200)
				.extract().response();
		
		//convert the response to JSON
			JsonPath jsonpath = response.jsonPath();
			
		//extract the values
			String name = jsonpath.getString("name");
			String phoneNumber = jsonpath.getString("phone_number");
		

	}

}
