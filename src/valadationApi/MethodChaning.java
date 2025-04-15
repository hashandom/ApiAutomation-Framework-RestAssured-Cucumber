package valadationApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import org.testng.Assert;

import file.Payload;
import file.ReusableMethods;

public class MethodChaning {

	public static void main(String[] args) {
		
		String newAddress = "25/a/1,gangaboda ed ,wevlala , piliyandala";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response=	 
		 given()
			.log().all()
			.queryParam("key","qaclick123")
			.header("Content-Type","application/json")
			.body(Payload.payload())
		.when()
			.post("maps/api/place/add/json")
		.then()
			.statusCode(200).body("scope" , equalTo("APP"))
			.header("Server", equalTo("Apache/2.4.52 (Ubuntu)"))
			.extract().response()
		.asString();
		
	
		//convert string into JSON format
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.print("place id  " + place_id );
		
		/////////////////////////////////////////////////////////////////////
		
		given()
			.log().all()
			.queryParam("key","qaclick123")
			.header("Content-Type","application/json")
			.body("{\r\n"
				    + "    \"place_id\": \"" + place_id + "\",\r\n"
				    + "    \"address\": \"" + newAddress + "\",\r\n"
				    + "    \"key\": \"qaclick123\"\r\n"
				    + "}")
			.when()
			.put("maps/api/place/update/json")
		.then()
			.assertThat()
			.log().all()
			.statusCode(200)
			.body("msg" , equalTo("Address successfully updated"));
		
		////////////////////////////////////////////////////////////////////////
		
	String getResponse =	
	given()
		.log().all()
		.queryParam("key","qaclick123")
		.queryParam("place_id",place_id)
		
	   .when()
		.get("maps/api/place/get/json")
	.then()
		.assertThat()
		.log().all()
		.statusCode(200)
		.extract().response().asString();
	
//	JsonPath jsGet = new JsonPath(getResponse);
	JsonPath jsResponse = ReusableMethods.jsonToStringConversation(getResponse);
	String actualAddress = jsResponse.getString("address");
	
	System.out.print("this is the actual address" + actualAddress);
	
	Assert.assertEquals(actualAddress,newAddress,"actual address and new address are not same");
		
	}

}
