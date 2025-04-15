package file;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	

	public static JsonPath jsonToStringConversation(String getResponse) {
		JsonPath js = new JsonPath(getResponse);
		return	 js;
	}

}
