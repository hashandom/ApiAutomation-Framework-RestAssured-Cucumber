package serilizationInputBody;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MainApi {
	
	
	@Test
	public void  serverRequestAuto() {
		 {
			 
			 List<String> myList = new ArrayList<String>();
				myList.add("shop");
				myList.add("shoe");
					
				Location lc = new Location();
				lc.setIng(-38.383494);
				lc.setLat(33.427362);
				
			 MainPojo addPlace = new MainPojo();
				addPlace.setName("Frontline house");
				addPlace.setLanguage("French-IN");
				addPlace.setAddress("29, side layout, cohen 09");
				addPlace.setAccuracy(50);
				addPlace.setPhone_number("(+91) 983 893 3937");
				addPlace.setWebsite("http://google.com");	 
				addPlace.setLocation(lc);
				addPlace.setTypes( myList );
				
			
			
			
			 
			 
			RestAssured.baseURI = "https://rahulshettyacademy.com";
		   
				
	String response=		
				given()
				.log().all()
				.queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(addPlace)
			
			.when().post("maps/api/place/add/json")
			.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.extract().asString();
	
	

			
			
		}
		
		
		}
		
		
	}




