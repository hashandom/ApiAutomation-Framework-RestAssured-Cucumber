package graphQlAutomations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import ecommerce.LoginRequest;
import ecommerce.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class QueryGraphQl {
	
	@Test
	public void login() {
		
		
	String response =	given()
			.log().all()
			.header("Content-Type","application/json")
			.body("{\"query\":\"query\\n{\\n  character(characterId: 13935)\\n  {\\n    id,\\n    name,\\n    type,\\n    status,\\n    gender\\n  }\\n}\",\"variables\":null}")
		.when()
			.post("https://rahulshettyacademy.com/gq/graphql")
		.then()
			.log().all()
			.extract().asString();
			
		
System.out.println("the response is " + response);
}
}
