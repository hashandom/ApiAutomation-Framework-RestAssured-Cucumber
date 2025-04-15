package reqResponseSpecifactionBuilder;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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
				
	//////////////////////////////////////////////////////////////////		
			
			//set the spe builders
				
		RequestSpecification reqSpec =	new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com")
			.addQueryParam("key", "qaclick123")
			.setContentType(ContentType.JSON).build();
		
		
		ResponseSpecification resSpec =	new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
			 
		   
	///////////////////////////////////////////////////////////////////			
	RequestSpecification res=		
				given()
				.spec( reqSpec)
				.log().all()		
				.body(addPlace);
			
	Response response=res.when().post("maps/api/place/add/json")
			.then()
				.log().all()
				.spec(resSpec)
				.extract()
				.response();
	
	String responseString = response.asString();
	System.out.println( responseString);
			
			
		}
		
		
		}
		
		
	}




