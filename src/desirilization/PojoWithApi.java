package desirilization;


import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;
import file.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PojoWithApi {
	
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
		
			
			MainPojoClass mj =	given()
				.log().all()
				.queryParam("access_token",access_token) 
			
			.when().get("oauthapi/getCourseDetails")
			.then()
				.log().all()
				.assertThat()
				.statusCode(401).extract().as(MainPojoClass.class);
				
			String instructor = mj.getInstructor();
			System.out.println("the instructor name is " + instructor);
			
//			String coureTitle = mj.getCourses().getApi().get(0).getCourseTitle();
//			int coursePrice = mj.getCourses().getApi().get(1).getPrice();

//			int size = mj.getCourses().getApi().size();
//			
//			for(int j =0 ; j<size ; j++) {
//				if(mj.getCourses().getApi().get(j).getCourseTitle().equalsIgnoreCase("soapui webservice testing")) {
//					System.out.println("the price of the course" + mj.getCourses().getApi().get(j).getPrice());
//					break;
//				}
//			}
			
			//print all the course name of the web automation
			List<SubChildWebAutoamtion> webAutoationApi = mj.getCourses().getWebAutomation();
			for(int i =0;i<webAutoationApi.size();i++) {
				System.out.println("the course name is" + webAutoationApi.get(i).getCourseTitle());
			}
			
		}
		
		
		}
		
		
	}



