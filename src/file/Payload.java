package file;

public class Payload {
	
	public static String payload(){
		return 
				"{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String createIssuePayload(){
		return 
				"{\r\n"
				+ "  \"fields\": {\r\n"
				+ "    \"project\": {\r\n"
				+ "      \"key\": \"SCRUM\"\r\n"
				+ "    },\r\n"
				+ "    \"summary\": \"drop down is not working\",\r\n"
				+ "    \"description\": \"This is a test issue created using the Jira REST API.\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "      \"name\": \"Task\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}

	public static void main(String[] args) {
		

	}

}
