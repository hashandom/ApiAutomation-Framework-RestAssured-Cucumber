package graphQlAutomations;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class MutationGraphql {

	@Test
	public void login() {
		
		
	String response =	given()
			.log().all()
			.header("Content-Type","application/json")
			.body("{\"query\":\"mutation {\\n  createLocation(location: {name: \\\"india\\\", type: \\\"south\\\", dimension: \\\"234\\\"}) {\\n    id\\n  }\\n  createCharacter(character: {name: \\\"hashan\\\", type:\\\"match\\\",status: \\\"live\\\", gender: \\\"male\\\",species:\\\"fantacy\\\",locationId: 20102,image:\\\"//kfkd\\\",originId: 20102}) {\\n    id\\n  }\\n  \\n  createEpisode(episode:{\\n    name : \\\"www\\\",\\n    air_date :\\\"fdfjdk\\\",\\n    episode : \\\"nfmnmfn\\\"\\n  }){\\n    id\\n  }\\n}\\n\",\"variables\":null}")
		.when()
			.post("https://rahulshettyacademy.com/gq/graphql")
		.then()
			.log().all()
			.extract().asString();
			
		
System.out.println("the response is " + response);
}
}