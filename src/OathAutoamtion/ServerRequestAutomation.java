package OathAutoamtion;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import file.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ServerRequestAutomation {
	
	@Test
	public void  serverRequestAuto() {
		 {
			RestAssured.baseURI = "https://rahulshettyacademy.com";
		   
				
	String response=		
				given()
				.log().all()
				.formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type","client_credentials")
				.formParam("scope","trust") 
			
			.when().post("oauthapi/oauth2/resourceOwner/token")
			.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.extract().asString();
	
	JsonPath js = new JsonPath(response);
	
		String access_token = js.getString("access_token");		
		System.out.println("access token is " + access_token );
		
			
			String response1 =	given()
				.log().all()
				.queryParam("access_token",access_token) 
			
			.when().get("oauthapi/getCourseDetails")
			.then()
				.log().all()
				.assertThat()
				.statusCode(401).extract().asString();
				
			System.out.println("the response is " + response1);
			
		}
		
		
	}

}
